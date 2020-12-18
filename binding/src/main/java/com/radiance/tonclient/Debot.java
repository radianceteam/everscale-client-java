package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  
 */
public class Debot {

    /**
     *  
     */
    public static class DebotAction  {

        public DebotAction(String description, String name, Number actionType, Number to, String attributes, String misc) {

            this.description = description;

            this.name = name;

            this.actionType = actionType;

            this.to = to;

            this.attributes = attributes;

            this.misc = misc;

        }
        public DebotAction(String description, String name, Number actionType, Number to, String attributes) {

            this.description = description;

            this.name = name;

            this.actionType = actionType;

            this.to = to;

            this.attributes = attributes;

        }
        public DebotAction(String description, String name, Number actionType, Number to) {

            this.description = description;

            this.name = name;

            this.actionType = actionType;

            this.to = to;

        }
        public DebotAction(String description, String name, Number actionType) {

            this.description = description;

            this.name = name;

            this.actionType = actionType;

        }
        public DebotAction(String description, String name) {

            this.description = description;

            this.name = name;

        }
        public DebotAction(String description) {

            this.description = description;

        }
        public DebotAction() {

        }


        @JsonProperty("description")
        private String description;
        /**
         * Should be used by Debot Browser as name ofmenu item.
         */
        public String getDescription() {
            return description;
        }
        /**
         * Should be used by Debot Browser as name ofmenu item.
         */
        public void setDescription(String value) {
            this.description = value;
        }

        @JsonProperty("name")
        private String name;
        /**
         * Can be a debot function name or a print string(for Print Action).
         */
        public String getName() {
            return name;
        }
        /**
         * Can be a debot function name or a print string(for Print Action).
         */
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("action_type")
        private Number actionType;
        /**
         * 
         */
        public Number getActionType() {
            return actionType;
        }
        /**
         * 
         */
        public void setActionType(Number value) {
            this.actionType = value;
        }

        @JsonProperty("to")
        private Number to;
        /**
         * 
         */
        public Number getTo() {
            return to;
        }
        /**
         * 
         */
        public void setTo(Number value) {
            this.to = value;
        }

        @JsonProperty("attributes")
        private String attributes;
        /**
         * In the form of "param=value,flag".attribute example: instant, args, fargs, sign.
         */
        public String getAttributes() {
            return attributes;
        }
        /**
         * In the form of "param=value,flag".attribute example: instant, args, fargs, sign.
         */
        public void setAttributes(String value) {
            this.attributes = value;
        }

        @JsonProperty("misc")
        private String misc;
        /**
         * Used by debot only.
         */
        public String getMisc() {
            return misc;
        }
        /**
         * Used by debot only.
         */
        public void setMisc(String value) {
            this.misc = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((description==null?null:("\"description\":\""+description+"\"")),(name==null?null:("\"name\":\""+name+"\"")),(actionType==null?null:("\"action_type\":"+actionType)),(to==null?null:("\"to\":"+to)),(attributes==null?null:("\"attributes\":\""+attributes+"\"")),(misc==null?null:("\"misc\":\""+misc+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    public static abstract class ParamsOfAppDebotBrowser {

    /**
     *  
     */
    public static class Log extends ParamsOfAppDebotBrowser  {

        public Log(String msg) {

            this.msg = msg;

        }
        public Log() {

        }


        @JsonProperty("msg")
        private String msg;
        /**
         * 
         */
        public String getMsg() {
            return msg;
        }
        /**
         * 
         */
        public void setMsg(String value) {
            this.msg = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Log\"",(msg==null?null:("\"msg\":\""+msg+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Switch extends ParamsOfAppDebotBrowser  {

        public Switch(Number contextId) {

            this.contextId = contextId;

        }
        public Switch() {

        }


        @JsonProperty("context_id")
        private Number contextId;
        /**
         * 
         */
        public Number getContextId() {
            return contextId;
        }
        /**
         * 
         */
        public void setContextId(Number value) {
            this.contextId = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Switch\"",(contextId==null?null:("\"context_id\":"+contextId))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class ShowAction extends ParamsOfAppDebotBrowser  {

        public ShowAction(DebotAction action) {

            this.action = action;

        }
        public ShowAction() {

        }


        @JsonProperty("action")
        private DebotAction action;
        /**
         * 
         */
        public DebotAction getAction() {
            return action;
        }
        /**
         * 
         */
        public void setAction(DebotAction value) {
            this.action = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"ShowAction\"",(action==null?null:("\"action\":"+action))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Input extends ParamsOfAppDebotBrowser  {

        public Input(String prompt) {

            this.prompt = prompt;

        }
        public Input() {

        }


        @JsonProperty("prompt")
        private String prompt;
        /**
         * 
         */
        public String getPrompt() {
            return prompt;
        }
        /**
         * 
         */
        public void setPrompt(String value) {
            this.prompt = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Input\"",(prompt==null?null:("\"prompt\":\""+prompt+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

        public static final GetSigningBox GetSigningBox = new GetSigningBox();

    /**
     *  Signing box returned is owned and disposed by debot engine
     */
    public static class GetSigningBox extends ParamsOfAppDebotBrowser  {

        public GetSigningBox() {

        }



        @Override
        public String toString() {
            return "{"+"\"type\":\"GetSigningBox\""+"}";
        }
    }

    /**
     *  
     */
    public static class InvokeDebot extends ParamsOfAppDebotBrowser  {

        public InvokeDebot(String debotAddr, DebotAction action) {

            this.debotAddr = debotAddr;

            this.action = action;

        }
        public InvokeDebot(String debotAddr) {

            this.debotAddr = debotAddr;

        }
        public InvokeDebot() {

        }


        @JsonProperty("debot_addr")
        private String debotAddr;
        /**
         * 
         */
        public String getDebotAddr() {
            return debotAddr;
        }
        /**
         * 
         */
        public void setDebotAddr(String value) {
            this.debotAddr = value;
        }

        @JsonProperty("action")
        private DebotAction action;
        /**
         * 
         */
        public DebotAction getAction() {
            return action;
        }
        /**
         * 
         */
        public void setAction(DebotAction value) {
            this.action = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"InvokeDebot\"",(debotAddr==null?null:("\"debot_addr\":\""+debotAddr+"\"")),(action==null?null:("\"action\":"+action))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    public static abstract class ResultOfAppDebotBrowser {

    /**
     *  
     */
    public static class Input extends ResultOfAppDebotBrowser  {

        public Input(String value) {

            this.value = value;

        }
        public Input() {

        }


        @JsonProperty("value")
        private String value;
        /**
         * 
         */
        public String getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(String value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Input\"",(value==null?null:("\"value\":\""+value+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class GetSigningBox extends ResultOfAppDebotBrowser  {

        public GetSigningBox(Integer signingBox) {

            this.signingBox = signingBox;

        }
        public GetSigningBox() {

        }


        @JsonProperty("signing_box")
        private Integer signingBox;
        /**
         * Signing box is owned and disposed by debot engine
         */
        public Integer getSigningBox() {
            return signingBox;
        }
        /**
         * Signing box is owned and disposed by debot engine
         */
        public void setSigningBox(Integer value) {
            this.signingBox = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"GetSigningBox\"",(signingBox==null?null:("\"signing_box\":"+signingBox))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

        public static final InvokeDebot InvokeDebot = new InvokeDebot();

    /**
     *  
     */
    public static class InvokeDebot extends ResultOfAppDebotBrowser  {

        public InvokeDebot() {

        }



        @Override
        public String toString() {
            return "{"+"\"type\":\"InvokeDebot\""+"}";
        }
    }
}
    private TONContext context;

    public Debot(TONContext context) {
        this.context = context;
    }

   /**
    * Downloads debot smart contract from blockchain and switches it tocontext zero.Returns a debot handle which can be used later in `execute` function.This function must be used by Debot Browser to start a dialog with debot.While the function is executing, several Browser Callbacks can be called,since the debot tries to display all actions from the context 0 to the user.<p># Remarks`start` is equivalent to `fetch` + switch to context 0.
    *
    * @param address 
    * @param appObject 
    */
    public CompletableFuture<Integer> start(String address, AppDebotBrowser appObject) {
        return context.requestJSONCallback("debot.start", "{"+(address==null?"":("\"address\":\""+address+"\""))+"}", (params,type) -> {
                Integer reqId = (Integer)((Map)params).get("app_request_id");
                Map data = (Map)((Map)params).get("request_data");
                System.out.println("-- " + data);
                switch ((String)data.remove("type")) {

                    case "Log":
                        try {
                            ParamsOfAppDebotBrowser.Log p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Log.class);
                            System.out.println("!! " + p);
                            appObject.log(p.getMsg());
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                    case "Switch":
                        try {
                            ParamsOfAppDebotBrowser.Switch p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Switch.class);
                            System.out.println("!! " + p);
                            appObject.switchTo(p.getContextId());
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                    case "ShowAction":
                        try {
                            ParamsOfAppDebotBrowser.ShowAction p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.ShowAction.class);
                            System.out.println("!! " + p);
                            appObject.showAction(p.getAction());
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                    case "Input":
                        try {
                            ParamsOfAppDebotBrowser.Input p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Input.class);
                            System.out.println("!! " + p);
                            appObject.input(p.getPrompt()).thenAccept(res -> {
                                new Client(context).resolveAppRequest(
                                    reqId,
                                    new Client.AppRequestResult.Ok(new ResultOfAppDebotBrowser.Input(res))
                                );
                            });
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                    case "GetSigningBox":
                        try {
                            appObject.getSigningBox().thenAccept(res -> {
                                new Client(context).resolveAppRequest(
                                    reqId,
                                    new Client.AppRequestResult.Ok(new ResultOfAppDebotBrowser.GetSigningBox(res))
                                );
                            });
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                    case "InvokeDebot":
                        try {
                            ParamsOfAppDebotBrowser.InvokeDebot p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.InvokeDebot.class);
                            System.out.println("!! " + p);
                            appObject.invokeDebot(p.getDebotAddr(),p.getAction()).thenAccept(res -> {
                                new Client(context).resolveAppRequest(
                                    reqId,
                                    new Client.AppRequestResult.Ok(new ResultOfAppDebotBrowser.InvokeDebot())
                                );
                            });
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                }
            }, Object.class)
            .thenApply(json -> TONContext.convertValue(json.findValue("debot_handle"), Integer.class));
    }

   /**
    * Downloads debot smart contract (code and data) from blockchain and createsan instance of Debot Engine for it.<p># RemarksIt does not switch debot to context 0. Browser Callbacks are not called.
    *
    * @param address 
    * @param appObject 
    */
    public CompletableFuture<Integer> fetch(String address, AppDebotBrowser appObject) {
        return context.requestJSONCallback("debot.fetch", "{"+(address==null?"":("\"address\":\""+address+"\""))+"}", (params,type) -> {
                Integer reqId = (Integer)((Map)params).get("app_request_id");
                Map data = (Map)((Map)params).get("request_data");
                System.out.println("-- " + data);
                switch ((String)data.remove("type")) {

                    case "Log":
                        try {
                            ParamsOfAppDebotBrowser.Log p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Log.class);
                            System.out.println("!! " + p);
                            appObject.log(p.getMsg());
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                    case "Switch":
                        try {
                            ParamsOfAppDebotBrowser.Switch p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Switch.class);
                            System.out.println("!! " + p);
                            appObject.switchTo(p.getContextId());
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                    case "ShowAction":
                        try {
                            ParamsOfAppDebotBrowser.ShowAction p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.ShowAction.class);
                            System.out.println("!! " + p);
                            appObject.showAction(p.getAction());
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                    case "Input":
                        try {
                            ParamsOfAppDebotBrowser.Input p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Input.class);
                            System.out.println("!! " + p);
                            appObject.input(p.getPrompt()).thenAccept(res -> {
                                new Client(context).resolveAppRequest(
                                    reqId,
                                    new Client.AppRequestResult.Ok(new ResultOfAppDebotBrowser.Input(res))
                                );
                            });
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                    case "GetSigningBox":
                        try {
                            appObject.getSigningBox().thenAccept(res -> {
                                new Client(context).resolveAppRequest(
                                    reqId,
                                    new Client.AppRequestResult.Ok(new ResultOfAppDebotBrowser.GetSigningBox(res))
                                );
                            });
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                    case "InvokeDebot":
                        try {
                            ParamsOfAppDebotBrowser.InvokeDebot p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.InvokeDebot.class);
                            System.out.println("!! " + p);
                            appObject.invokeDebot(p.getDebotAddr(),p.getAction()).thenAccept(res -> {
                                new Client(context).resolveAppRequest(
                                    reqId,
                                    new Client.AppRequestResult.Ok(new ResultOfAppDebotBrowser.InvokeDebot())
                                );
                            });
                        } catch (Exception e) {
                            new Client(context).resolveAppRequest(reqId, new Client.AppRequestResult.Error(e.getMessage()));
                        }
                        break;

                }
            }, Object.class)
            .thenApply(json -> TONContext.convertValue(json.findValue("debot_handle"), Integer.class));
    }

   /**
    * Calls debot engine referenced by debot handle to execute input action.Calls Debot Browser Callbacks if needed.<p># RemarksChain of actions can be executed if input action generates a list of subactions.
    *
    * @param debotHandle 
    * @param action 
    */
    public CompletableFuture<Void> execute(Integer debotHandle, DebotAction action) {
        return context.requestJSON("debot.execute", "{"+Stream.of((debotHandle==null?null:("\"debot_handle\":"+debotHandle)),(action==null?null:("\"action\":"+action))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * Removes handle from Client Context and drops debot engine referenced by that handle.
    *
    * @param debotHandle 
    */
    public CompletableFuture<Void> remove(Integer debotHandle) {
        return context.requestJSON("debot.remove", "{"+(debotHandle==null?"":("\"debot_handle\":"+debotHandle))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

}
