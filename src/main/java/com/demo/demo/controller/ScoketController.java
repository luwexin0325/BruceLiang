package com.demo.demo.controller;

import com.demo.demo.config.WebSocketServer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luwenxin
 * @create 2020-03-13
 */
@RestController
public class ScoketController {
    @RequestMapping("/push/{sToken}")
    public String pushToWeb(@RequestParam String message, @PathVariable String sToken) {
        WebSocketServer.sendMsg(message,sToken);
        return "ok";
    }
}
