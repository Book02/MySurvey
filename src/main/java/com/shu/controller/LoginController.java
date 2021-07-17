package com.shu.controller;

import com.google.common.base.Strings;
import com.shu.entity.Admin;
import com.shu.service.AdminService;
import com.shu.utils.MD5Utils;
import com.shu.utils.MapControl;
import com.shu.utils.MapParameter;
import com.shu.utils.SessionUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody Map<String, Object> map,HttpServletRequest request){
        String account =map.get("account")+"";
        String password=map.get("password")+"" ;
        if(Strings.isNullOrEmpty(account)||Strings.isNullOrEmpty(password)){
            return MapControl.getInstance().success("用户名或密码不能为空").getMap();
        }
        Admin admin=adminService.login(account, MD5Utils.getMD5(password));
        if(admin!=null){
            //??session视频
            SessionUtils.setAdmin(request,admin);
            return MapControl.getInstance().success().getMap();
        }else{
            return MapControl.getInstance().error("用户名或密码错误").getMap();
        }
    }
}


