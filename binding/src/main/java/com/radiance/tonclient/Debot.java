package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
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
         * Should be used by Debot Browser as name of menu item.
         */
        public String getDescription() {
            return description;
        }
        /**
         * Should be used by Debot Browser as name of menu item.
         */
        public void setDescription(String value) {
            this.description = value;
        }

        @JsonProperty("name")
        private String name;
        /**
         * Can be a debot function name or a print string (for Print Action).
         */
        public String getName() {
            return name;
        }
        /**
         * Can be a debot function name or a print string (for Print Action).
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
         * In the form of "param=value,flag". attribute example: instant, args, fargs, sign.
         */
        public String getAttributes() {
            return attributes;
        }
        /**
         * In the form of "param=value,flag". attribute example: instant, args, fargs, sign.
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
    /**
     *  
     */
    public static class DebotInfo  {

        public DebotInfo(String name, String version, String publisher, String key, String author, String support, String hello, String language, String dabi, String icon, String[] interfaces) {

            this.name = name;

            this.version = version;

            this.publisher = publisher;

            this.key = key;

            this.author = author;

            this.support = support;

            this.hello = hello;

            this.language = language;

            this.dabi = dabi;

            this.icon = icon;

            this.interfaces = interfaces;

        }
        public DebotInfo(String name, String version, String publisher, String key, String author, String support, String hello, String language, String dabi, String icon) {

            this.name = name;

            this.version = version;

            this.publisher = publisher;

            this.key = key;

            this.author = author;

            this.support = support;

            this.hello = hello;

            this.language = language;

            this.dabi = dabi;

            this.icon = icon;

        }
        public DebotInfo(String name, String version, String publisher, String key, String author, String support, String hello, String language, String dabi) {

            this.name = name;

            this.version = version;

            this.publisher = publisher;

            this.key = key;

            this.author = author;

            this.support = support;

            this.hello = hello;

            this.language = language;

            this.dabi = dabi;

        }
        public DebotInfo(String name, String version, String publisher, String key, String author, String support, String hello, String language) {

            this.name = name;

            this.version = version;

            this.publisher = publisher;

            this.key = key;

            this.author = author;

            this.support = support;

            this.hello = hello;

            this.language = language;

        }
        public DebotInfo(String name, String version, String publisher, String key, String author, String support, String hello) {

            this.name = name;

            this.version = version;

            this.publisher = publisher;

            this.key = key;

            this.author = author;

            this.support = support;

            this.hello = hello;

        }
        public DebotInfo(String name, String version, String publisher, String key, String author, String support) {

            this.name = name;

            this.version = version;

            this.publisher = publisher;

            this.key = key;

            this.author = author;

            this.support = support;

        }
        public DebotInfo(String name, String version, String publisher, String key, String author) {

            this.name = name;

            this.version = version;

            this.publisher = publisher;

            this.key = key;

            this.author = author;

        }
        public DebotInfo(String name, String version, String publisher, String key) {

            this.name = name;

            this.version = version;

            this.publisher = publisher;

            this.key = key;

        }
        public DebotInfo(String name, String version, String publisher) {

            this.name = name;

            this.version = version;

            this.publisher = publisher;

        }
        public DebotInfo(String name, String version) {

            this.name = name;

            this.version = version;

        }
        public DebotInfo(String name) {

            this.name = name;

        }
        public DebotInfo() {

        }


        @JsonProperty("name")
        private String name;
        /**
         * 
         */
        public String getName() {
            return name;
        }
        /**
         * 
         */
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("version")
        private String version;
        /**
         * 
         */
        public String getVersion() {
            return version;
        }
        /**
         * 
         */
        public void setVersion(String value) {
            this.version = value;
        }

        @JsonProperty("publisher")
        private String publisher;
        /**
         * 
         */
        public String getPublisher() {
            return publisher;
        }
        /**
         * 
         */
        public void setPublisher(String value) {
            this.publisher = value;
        }

        @JsonProperty("key")
        private String key;
        /**
         * 
         */
        public String getKey() {
            return key;
        }
        /**
         * 
         */
        public void setKey(String value) {
            this.key = value;
        }

        @JsonProperty("author")
        private String author;
        /**
         * 
         */
        public String getAuthor() {
            return author;
        }
        /**
         * 
         */
        public void setAuthor(String value) {
            this.author = value;
        }

        @JsonProperty("support")
        private String support;
        /**
         * 
         */
        public String getSupport() {
            return support;
        }
        /**
         * 
         */
        public void setSupport(String value) {
            this.support = value;
        }

        @JsonProperty("hello")
        private String hello;
        /**
         * 
         */
        public String getHello() {
            return hello;
        }
        /**
         * 
         */
        public void setHello(String value) {
            this.hello = value;
        }

        @JsonProperty("language")
        private String language;
        /**
         * 
         */
        public String getLanguage() {
            return language;
        }
        /**
         * 
         */
        public void setLanguage(String value) {
            this.language = value;
        }

        @JsonProperty("dabi")
        private String dabi;
        /**
         * 
         */
        public String getDabi() {
            return dabi;
        }
        /**
         * 
         */
        public void setDabi(String value) {
            this.dabi = value;
        }

        @JsonProperty("icon")
        private String icon;
        /**
         * 
         */
        public String getIcon() {
            return icon;
        }
        /**
         * 
         */
        public void setIcon(String value) {
            this.icon = value;
        }

        @JsonProperty("interfaces")
        private String[] interfaces;
        /**
         * 
         */
        public String[] getInterfaces() {
            return interfaces;
        }
        /**
         * 
         */
        public void setInterfaces(String[] value) {
            this.interfaces = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((name==null?null:("\"name\":\""+name+"\"")),(version==null?null:("\"version\":\""+version+"\"")),(publisher==null?null:("\"publisher\":\""+publisher+"\"")),(key==null?null:("\"key\":\""+key+"\"")),(author==null?null:("\"author\":\""+author+"\"")),(support==null?null:("\"support\":\""+support+"\"")),(hello==null?null:("\"hello\":\""+hello+"\"")),(language==null?null:("\"language\":\""+language+"\"")),(dabi==null?null:("\"dabi\":\""+dabi+"\"")),(icon==null?null:("\"icon\":\""+icon+"\"")),(interfaces==null?null:("\"interfaces\":\""+Arrays.toString(interfaces)+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class RegisteredDebot  {

        public RegisteredDebot(Integer debotHandle, String debotAbi, DebotInfo info) {

            this.debotHandle = debotHandle;

            this.debotAbi = debotAbi;

            this.info = info;

        }
        public RegisteredDebot(Integer debotHandle, String debotAbi) {

            this.debotHandle = debotHandle;

            this.debotAbi = debotAbi;

        }
        public RegisteredDebot(Integer debotHandle) {

            this.debotHandle = debotHandle;

        }
        public RegisteredDebot() {

        }


        @JsonProperty("debot_handle")
        private Integer debotHandle;
        /**
         * 
         */
        public Integer getDebotHandle() {
            return debotHandle;
        }
        /**
         * 
         */
        public void setDebotHandle(Integer value) {
            this.debotHandle = value;
        }

        @JsonProperty("debot_abi")
        private String debotAbi;
        /**
         * 
         */
        public String getDebotAbi() {
            return debotAbi;
        }
        /**
         * 
         */
        public void setDebotAbi(String value) {
            this.debotAbi = value;
        }

        @JsonProperty("info")
        private DebotInfo info;
        /**
         * 
         */
        public DebotInfo getInfo() {
            return info;
        }
        /**
         * 
         */
        public void setInfo(DebotInfo value) {
            this.info = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((debotHandle==null?null:("\"debot_handle\":"+debotHandle)),(debotAbi==null?null:("\"debot_abi\":\""+debotAbi+"\"")),(info==null?null:("\"info\":"+info))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
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

        public static final SwitchCompleted SwitchCompleted = new SwitchCompleted();

    /**
     *  
     */
    public static class SwitchCompleted extends ParamsOfAppDebotBrowser  {

        public SwitchCompleted() {

        }



        @Override
        public String toString() {
            return "{"+"\"type\":\"SwitchCompleted\""+"}";
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

    /**
     *  
     */
    public static class Send extends ParamsOfAppDebotBrowser  {

        public Send(String message) {

            this.message = message;

        }
        public Send() {

        }


        @JsonProperty("message")
        private String message;
        /**
         * Message body contains interface function and parameters.
         */
        public String getMessage() {
            return message;
        }
        /**
         * Message body contains interface function and parameters.
         */
        public void setMessage(String value) {
            this.message = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Send\"",(message==null?null:("\"message\":\""+message+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Approve extends ParamsOfAppDebotBrowser  {

        public Approve(Object activity) {

            this.activity = activity;

        }
        public Approve() {

        }


        @JsonProperty("activity")
        private Object activity;
        /**
         * 
         */
        public Object getActivity() {
            return activity;
        }
        /**
         * 
         */
        public void setActivity(Object value) {
            this.activity = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Approve\"",(activity==null?null:("\"activity\":"+activity))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
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

    /**
     *  
     */
    public static class Approve extends ResultOfAppDebotBrowser  {

        public Approve(Boolean approved) {

            this.approved = approved;

        }
        public Approve() {

        }


        @JsonProperty("approved")
        private Boolean approved;
        /**
         * 
         */
        public Boolean getApproved() {
            return approved;
        }
        /**
         * 
         */
        public void setApproved(Boolean value) {
            this.approved = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Approve\"",(approved==null?null:("\"approved\":"+approved))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    private TONContext context;

    public Debot(TONContext context) {
        this.context = context;
    }

   /**
    * Downloads debot smart contract (code and data) from blockchain and createsan instance of Debot Engine for it.<p># RemarksIt does not switch debot to context 0. Browser Callbacks are not called.
    *
    * @param address 
    * @param appObject 
    */
    public CompletableFuture<RegisteredDebot> init(String address, AppDebotBrowser appObject) {
        return context.requestJSONCallback("debot.init", "{"+(address==null?"":("\"address\":\""+address+"\""))+"}", (params,type) -> {
                Map data = (Map)(type==3?((Map)params).get("request_data"):params);
                switch ((String)data.remove("type")) {

                    case "Log":
                        try {
                            ParamsOfAppDebotBrowser.Log p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Log.class);
                            appObject.log(p.getMsg());
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "Switch":
                        try {
                            ParamsOfAppDebotBrowser.Switch p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Switch.class);
                            appObject.switchTo(p.getContextId());
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "SwitchCompleted":
                        try {
                            appObject.switchCompleted();
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "ShowAction":
                        try {
                            ParamsOfAppDebotBrowser.ShowAction p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.ShowAction.class);
                            appObject.showAction(p.getAction());
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "Input":
                        try {
                            ParamsOfAppDebotBrowser.Input p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Input.class);
                            appObject.input(p.getPrompt()).whenComplete((res,ex) -> {
                                new Client(context).resolveAppRequest(
                                    (Integer)((Map)params).get("app_request_id"),
                                    ex==null?
                                        new Client.AppRequestResult.Ok(new ResultOfAppDebotBrowser.Input(res)):
                                        new Client.AppRequestResult.Error(ex.getMessage())
                                );
                            });
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "GetSigningBox":
                        try {
                            appObject.getSigningBox().whenComplete((res,ex) -> {
                                new Client(context).resolveAppRequest(
                                    (Integer)((Map)params).get("app_request_id"),
                                    ex==null?
                                        new Client.AppRequestResult.Ok(new ResultOfAppDebotBrowser.GetSigningBox(res)):
                                        new Client.AppRequestResult.Error(ex.getMessage())
                                );
                            });
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "InvokeDebot":
                        try {
                            ParamsOfAppDebotBrowser.InvokeDebot p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.InvokeDebot.class);
                            appObject.invokeDebot(p.getDebotAddr(),p.getAction()).whenComplete((res,ex) -> {
                                new Client(context).resolveAppRequest(
                                    (Integer)((Map)params).get("app_request_id"),
                                    ex==null?
                                        new Client.AppRequestResult.Ok(new ResultOfAppDebotBrowser.InvokeDebot()):
                                        new Client.AppRequestResult.Error(ex.getMessage())
                                );
                            });
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "Send":
                        try {
                            ParamsOfAppDebotBrowser.Send p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Send.class);
                            appObject.send(p.getMessage());
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "Approve":
                        try {
                            ParamsOfAppDebotBrowser.Approve p = new ObjectMapper().convertValue(data, ParamsOfAppDebotBrowser.Approve.class);
                            appObject.approve(p.getActivity()).whenComplete((res,ex) -> {
                                new Client(context).resolveAppRequest(
                                    (Integer)((Map)params).get("app_request_id"),
                                    ex==null?
                                        new Client.AppRequestResult.Ok(new ResultOfAppDebotBrowser.Approve(res)):
                                        new Client.AppRequestResult.Error(ex.getMessage())
                                );
                            });
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                }
            }, Object.class)
            .thenApply(json -> TONContext.convertValue(json, RegisteredDebot.class));
    }

   /**
    * Downloads debot smart contract from blockchain and switches it tocontext zero.<p>This function must be used by Debot Browser to start a dialog with debot.While the function is executing, several Browser Callbacks can be called,since the debot tries to display all actions from the context 0 to the user.<p>When the debot starts SDK registers `BrowserCallbacks` AppObject.Therefore when `debote.remove` is called the debot is being deleted and the callback is calledwith `finish`=`true` which indicates that it will never be used again.
    *
    * @param debotHandle 
    */
    public CompletableFuture<Void> start(Integer debotHandle) {
        return context.requestJSON("debot.start", "{"+(debotHandle==null?"":("\"debot_handle\":"+debotHandle))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * Downloads DeBot from blockchain and creates and fetches its metadata.
    *
    * @param address 
    */
    public CompletableFuture<DebotInfo> fetch(String address) {
        return context.requestJSON("debot.fetch", "{"+(address==null?"":("\"address\":\""+address+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("info"), DebotInfo.class));
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
    * Used by Debot Browser to send response on Dinterface call or from other Debots.
    *
    * @param debotHandle 
    * @param message 
    */
    public CompletableFuture<Void> send(Integer debotHandle, String message) {
        return context.requestJSON("debot.send", "{"+Stream.of((debotHandle==null?null:("\"debot_handle\":"+debotHandle)),(message==null?null:("\"message\":\""+message+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
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
