package com.demo.demo.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author luwenxin
 * @create 2020-03-05
 */
@Controller
public class ThymeleafController {
    @RequestMapping("/show")
    @ResponseBody
    public Map<String,String> show(Model model){
        Map<String,String> map = Maps.newHashMap();
//        map.put("文欣","BruceLiang");
//        model.addAttribute("msg","你猜我是不是HelloWorld");
        return map;
    }

}
