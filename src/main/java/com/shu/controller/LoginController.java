package com.shu.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody Map<String, Object> map){
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        System.out.println(map);
        return map;
    }
}


