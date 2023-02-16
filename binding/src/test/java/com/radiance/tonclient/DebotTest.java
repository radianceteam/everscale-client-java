package com.radiance.tonclient;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import static com.radiance.tonclient.Debot.DebotAction;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.math.BigInteger;

public class DebotTest extends TestBase {
    private static final int EXIT_CHOICE = 9;

    static class Step {
        int choice;
        String[] inputs, expectedOutputs;
        List<String> outputs;
        Step[] invokes;

        Step(int choice, String[] inputs, String[] outputs, Step[] invokes) {
            this.choice = choice;
            this.inputs = inputs;
            expectedOutputs = outputs;
            this.outputs = new ArrayList<>();
            this.invokes = invokes;
        }

        Step(int choice, String[] inputs, String[] outputs) {
            this(choice, inputs, outputs, null);
        }

        Step(int choice, String[] outputs) {
            this(choice, null, outputs, null);
        }

        void addOutput(String message) {
            outputs.add(message);
        }

        void validate() {
            assertEquals(expectedOutputs.length, outputs.size());
            Iterator<String> it = outputs.iterator();
            for (String exp : expectedOutputs) {
                int pos = exp.indexOf("{}");
                if (pos < 0)
                    assertEquals(exp, it.next());
                else
                    assertEquals(exp.substring(0,pos), it.next().substring(0,pos));
            }
        }
    }

    static class TestBrowser implements AppDebotBrowser {
        Debot debot;
        String debotAddr, targetAddr;
        Step currentStep;
        List<DebotAction> availableActions;
        Crypto.KeyPair keys;

        TestBrowser(TONContext context, String debotAddr, String targetAddr, Crypto.KeyPair keys) {
            debot = new Debot(context);
            this.debotAddr = debotAddr;
            this.targetAddr = targetAddr;
            this.keys = keys;
        }

        TestBrowser(TONContext context, String debotAddr, Crypto.KeyPair keys, List<DebotAction> actions) {
            this(context, debotAddr, null, keys);
            availableActions = actions;
        }

        public CompletableFuture<Integer> getSigningBox() {
            return new Crypto(context).getSigningBox(keys.getPublic(), keys.getSecret());
        }

        public CompletableFuture<String> input(String prompt) {
            return CompletableFuture.completedFuture(currentStep.inputs[0]); 
        }

        public CompletableFuture<Void> invokeDebot(String debotAddr, Debot.DebotAction action) {
            return CompletableFuture.supplyAsync(() -> {
                TestBrowser browser = new TestBrowser(context, debotAddr, keys, Arrays.asList(new DebotAction[] {action}));
                try {
                    browser.execute(currentStep.invokes, false);
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                    throw new RuntimeException(e);
                }
                return null;
            });
        }

        public void log(String msg) {
            if (currentStep != null)
                currentStep.addOutput(msg);
        }

        public void showAction(Debot.DebotAction action) {
            availableActions.add(action);
        }

        public void switchTo(Number contextId) {
            availableActions = new ArrayList<>();
        }

        public void switchCompleted() { }

        public void send(String message) {
            System.out.println("DebotTest send message: '" + message + "'");
        }

        public CompletableFuture<Boolean> approve(Object activity) {
            return CompletableFuture.completedFuture(true);
        }

        void execute(Step[] steps, boolean start) throws InterruptedException, ExecutionException {
            Debot.RegisteredDebot debot = null;

            for (int i=0; i<=steps.length; i++) {
                if (i==0) {
                    if (start) {
                        debot = this.debot.init(debotAddr, this).get();
                        this.debot.start(debot.getDebotHandle()).get();
                    } else
                        this.debot.fetch(debotAddr).get();
                } else {
                    currentStep = steps[i-1];
                    this.debot.execute(debot.getDebotHandle(), availableActions.get(currentStep.choice - 1)).get();
                    currentStep.validate();
                }
            }

            this.debot.remove(debot.getDebotHandle());
        }

        void execute(Step[] steps) throws InterruptedException, ExecutionException {
            execute(steps, true);
        }
    }

    private String toHexBytes(String input) {
        return new BigInteger(1, input.getBytes()).toString(16);
    }

    private TestBrowser initDebot() throws Exception {
        Crypto.KeyPair keys = crypto.generateRandomSignKeys().get();
        Abi.ABI targetAbi = abiFromResource("/testDebotTarget.abi.json");
        Abi.ABI debotAbi = abiFromResource("/testDebot.abi.json");

        Abi.DeploySet targetDS = new Abi.DeploySet(tvcFromResource("/testDebotTarget.tvc"));
        String targetAddress = abiModule.encodeMessage(
            targetAbi,
            null, // address
            targetDS,
            new Abi.CallSet("constructor"),
            new Abi.Signer.Keys(keys),
            null, // processingTryIndex
            null
        ).get().getAddress();


        CompletableFuture<String> targetFuture = deployWithGiver(
            targetAbi,
            targetDS,
            new Abi.CallSet("constructor"),
            new Abi.Signer.Keys(keys)
        );
        targetFuture.join(); // wait for completion to avoid concurrency issues in node se

        CompletableFuture<String> debotFuture = deployWithGiver(
            debotAbi,
            new Abi.DeploySet(tvcFromResource("/testDebot.tvc")),
            new Abi.CallSet("constructor", null, "{" +
                //"\"debotAbi\": \"" + toHexBytes(((Abi.ABI.Serialized)debotAbi).getValue().toString()) + "\"," +
                "\"targetAbi\": \"" + toHexBytes(((Abi.ABI.Serialized)targetAbi).getValue().toString()) + "\"," +
                "\"targetAddr\": \"" + targetAddress + "\"" +
            "}"),
            new Abi.Signer.Keys(keys)
        );

        return new TestBrowser(context, debotFuture.get(), targetFuture.get(), keys);
    }

    @Test
    public void testDebotGoto() throws Exception {
        try {
        TestBrowser browser = initDebot();
        browser.execute(new Step[] {
            new Step(1, new String[] {"Test Goto Action"}),
            new Step(1, new String[] {"Debot Tests"}),
            new Step(EXIT_CHOICE, new String[] {})
        });
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    //@Test
    public void testDebotPrint() throws Exception {
        TestBrowser browser = initDebot();
        browser.execute(new Step[] {
            new Step(2, new String[] {"Test Print Action", "test2: instant print", "test instant print"}),
            new Step(1, new String[] {"test simple print"}),
            new Step(2, new String[] {"integer=1,addr=" + browser.targetAddr + ",string=test_string_1"}),
            new Step(3, new String[] {"Debot Tests"}),
            new Step(EXIT_CHOICE, new String[] {})
        });
    }

    //@Test
    public void testDebotRunAction() throws Exception {
        TestBrowser browser = initDebot();
        browser.execute(new Step[] {
            new Step(3, new String[] {}, new String[] {"Test Run Action"}),
            new Step(1, new String[] {"-1:1111111111111111111111111111111111111111111111111111111111111111"}, new String[] {"Test Instant Run", "test1: instant run 1", "test2: instant run 2"}),
            new Step(1, new String[] {}, new String[] {"Test Run Action"}),
            new Step(2, new String[] {"hello"}, new String[] {}),
            new Step(3, new String[] {}, new String[] {"integer=2,addr=-1:1111111111111111111111111111111111111111111111111111111111111111,string=hello"}),
            new Step(4, new String[] {}, new String[] {"Debot Tests"}),
            new Step(EXIT_CHOICE, new String[] {}, new String[] {})
        });
    }

    //@Test
    public void testDebotRunMethod() throws Exception {
        TestBrowser browser = initDebot();
        browser.execute(new Step[] {
            new Step(4, new String[] {"Test Run Method Action"}),
            new Step(1, new String[] {}),
            new Step(2, new String[] {"data=64"}),
            new Step(3, new String[] {"Debot Tests"}),
            new Step(EXIT_CHOICE, new String[] {})
        });
    }

    //@Test
    public void testDebotSendMsg() throws Exception {
        TestBrowser browser = initDebot();
        browser.execute(new Step[] {
            new Step(5, new String[] {"Test Send Msg Action"}),
            new Step(1, new String[] {"Sending message {}", "Transaction succeeded."}),
            new Step(2, new String[] {}),
            new Step(3, new String[] {"data=100"}),
            new Step(4, new String[] {"Debot Tests"}),
            new Step(EXIT_CHOICE, new String[] {})
        });
    }

    //@Test
    public void testDebotInvokeDebot() throws Exception {
        try {
        TestBrowser browser = initDebot();
        browser.execute(new Step[] {
            new Step(6, new String[] {browser.debotAddr}, new String[] {"Test Invoke Debot Action", "enter debot address:"}),
            new Step(1, new String[] {browser.debotAddr}, new String[] {"Test Invoke Debot Action", "enter debot address:"}, new Step[] {
                new Step(1, new String[] {"Print test string", "Debot is invoked"}),
                new Step(1, new String[] {"Sending message {}", "Transaction succeeded."})
            }),
            new Step(2, new String[] {"Debot Tests"}),
            new Step(EXIT_CHOICE, new String[] {})
        });
        } catch(Exception e) { e.printStackTrace(); throw e; }
    }

    //@Test
    public void testDebotEngineCalls() throws Exception {
        TestBrowser browser = initDebot();
        browser.execute(new Step[] {
            new Step(7, new String[] {"Test Engine Calls"}),
            new Step(1, new String[] {}),
            new Step(2, new String[] {}),
            new Step(3, new String[] {}),
            new Step(4, new String[] {}),
            new Step(5, new String[] {}),
            new Step(6, new String[] {"Debot Tests"}),
            new Step(EXIT_CHOICE, new String[] {})
        });
    }

    //@Test
    public void testMsigDebot() throws Exception {
        Crypto.KeyPair keys = crypto.generateRandomSignKeys().get();
        Abi.ABI walletAbi = abiFromResource("/SetcodeMultisigWallet.abi.json");
        Abi.ABI debotAbi = abiFromResource("/msigDebot.abi.json");

        CompletableFuture<String> debotFuture = deployWithGiver(
            debotAbi,
            new Abi.DeploySet(tvcFromResource("/msigDebot.tvc")),
            new Abi.CallSet("constructor", null, "{" +
                "\"options\": 3," +
                "\"debotAbi\": \"" + toHexBytes(((Abi.ABI.Serialized)debotAbi).getValue().toString()) + "\"," +
                "\"targetAbi\": \"" + toHexBytes(((Abi.ABI.Serialized)walletAbi).getValue().toString()) + "\"," +
                "\"targetAddr\": \"0:841288ed3b55d9cdafa806807f02a0ae0c169aa5edfe88a789a6482429756a94\"" +
            "}"),
            new Abi.Signer.Keys(keys)
        );

        TestBrowser browser = new TestBrowser(context, debotFuture.get(), (String)null, null);
        browser.execute(new Step[] {
            new Step(2, new String[] {}, new String[] {})
        });
    }

}