package com.shu.controller;

import com.shu.entity.Admin;
import com.shu.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class IndexController {

    @Value("classpath:init.json")
    private Resource resource;

    @GetMapping("/index")
    public String index(){
        return  "index";
    }


    @GetMapping("/menu")
    @ResponseBody
    public void menu(HttpServletResponse response){

        try {
            File file = resource.getFile();
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String str;
            StringBuffer sb = new StringBuffer();
            while ((str = bufferedReader.readLine()) !=null){
                sb.append(str);
            }
            bufferedReader.close();
            isr.close();
            inputStream.close();
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}