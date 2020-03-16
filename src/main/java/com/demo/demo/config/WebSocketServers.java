//package com.demo.demo.config;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.demo.demo.util.GuavaCacheUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.OnError;
//import javax.websocket.OnMessage;
//import javax.websocket.Session;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @author luwenxin
// * @create 2020-03-13
// */
//@ServerEndpoint("/websocket/{sToken}")
//@Component
//@Slf4j
//public class WebSocketServer {
//    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
//    //管理员聊天用户数目
//    private static ConcurrentHashMap<String, Integer> adminUserCountMap = new ConcurrentHashMap<>();
//    //在线管理员
//    private static AtomicInteger adminCount = new AtomicInteger(0);
//    //在线用户
//    private static AtomicInteger userCount = new AtomicInteger(0);
//    private Session session;
//    private String sToken;
//    private static final String SYS_STOKEN = "SYS";
//
//    /**
//     * @author: LWX
//     * @date: 2020-03-13 17:19
//     * 连接建立成功
//     */
//    public void onOpen(Session session, @PathParam("sToken") String sToken) {
//        if (sToken.endsWith("000")) {
//            //测试使用
//            GuavaCacheUtil.set(sToken, 0);
//        }
//        if (GuavaCacheUtil.get(sToken) == null) {
//            //sToken无效或失效
//            return;
//        }
//        this.session = session;
//        this.sToken = sToken;
//        if (webSocketMap.containsKey(sToken)) {
//            webSocketMap.remove(sToken);
//        }
//        webSocketMap.put(sToken, this);
//        if (sToken.startsWith("amdin")) {
//            adminCount.incrementAndGet();
//            if (adminUserCountMap.containsKey(sToken)) {
//                adminUserCountMap.remove(sToken);
//            }
//            adminUserCountMap.put(sToken, 0);
//        } else if (sToken.startsWith("user")) {
//            userCount.incrementAndGet();
//            //分配管理员
//            String adminsToken = getAdmin();
//            //通知用户管理员sToken
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("msg", adminsToken);
//            jsonObject.put("toUser", sToken);
//            jsonObject.put("fromUser", SYS_STOKEN);
//            jsonObject.put("code", 1);
//            this.sendMessage(jsonObject.toJSONString());
//            // 管理员用户数+1
//            adminUserCountMap.put(adminsToken, adminUserCountMap.get(adminsToken) + 1);
//        }
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session) {
//
//        JSONObject jsonObject = JSON.parseObject(message);
//        String toUser = jsonObject.getString("toUser");
//        if (StringUtils.isNotBlank(toUser) && webSocketMap.containsKey(toUser)) {
//            jsonObject.put("fromUser", sToken);
//            jsonObject.put("code", 0);
//            webSocketMap.get(toUser).sendMessage(jsonObject.toJSONString());
//        } else {
//            jsonObject.remove("toUser");
//            jsonObject.remove("msg");
//            jsonObject.put("toUser", sToken);
//            jsonObject.put("fromUser", SYS_STOKEN);
//            jsonObject.put("code", 404);
//            jsonObject.put("msg", "对方已下线");
//            webSocketMap.get(sToken).sendMessage(jsonObject.toJSONString());
//        }
//        log.info("sToken: {},message：{}", sToken, jsonObject.toJSONString());
//
//
//    }
//
//    @OnError
//    public void onError(Session session, Throwable error) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("toUser", sToken);
//        jsonObject.put("fromUser", SYS_STOKEN);
//        jsonObject.put("code", 500);
//        jsonObject.put("msg", "系统异常");
//        webSocketMap.get(sToken).sendMessage(jsonObject.toJSONString());
//        log.error("用户错误:" + sToken + ",原因:" + error.getMessage());
//    }
//
//    /**
//     * 实现服务器主动推送
//     */
//    public void sendMessage(String message) {
//        try {
//            this.session.getBasicRemote().sendText(message);
//        } catch (IOException e) {
//            log.error("socket error: {}", e);
//        }
//        log.info("socket send msg : {}", message);
//    }
//
//
//    /**
//     * @author: LWX
//     * @date: 2020-03-13 17:30
//     * 获取聊天用户最少的管理员sToken
//     */
//    private String getAdmin() {
//        if (adminUserCountMap.size() == 0) {
//            return null;
//        }
//        String sToken = "";
//        int count = 0;
//        Iterator<Map.Entry<String, Integer>> iterator = adminUserCountMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Integer> m = iterator.next();
//            if (StringUtils.isBlank(sToken)) {
//                sToken = m.getKey();
//                count = m.getValue();
//            } else if (m.getValue() < count) {
//                sToken = m.getKey();
//                count = m.getValue();
//            }
//        }
//        return sToken;
//    }
//
//    /**
//     * 自定义发送游戏
//     *
//     * @param msg
//     * @param sToken
//     */
//    public static void sendMsg(String msg, String sToken) {
//        if (StringUtils.isNotBlank(sToken) && webSocketMap.containsKey(sToken)) {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("msg", msg);
//            jsonObject.put("toUser", sToken);
//            jsonObject.put("fromUser", SYS_STOKEN);
//            jsonObject.put("code", 0);
//            webSocketMap.get(sToken).sendMessage(jsonObject.toJSONString());
//        } else {
////            throw new RRException("用户已下线");
//        }
//    }
//}
//
