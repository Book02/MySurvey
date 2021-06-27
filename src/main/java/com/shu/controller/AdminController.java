package com.shu.controller;

import com.shu.entity.Admin;
import com.shu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/create")
    @ResponseBody
    public String create(Admin admin){
      int result= adminService.create(admin);
      if(result<=0){
          return "错误";
      }else {
          return "正确";
      }
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        int result=adminService.delete(id);
        if(result<=0){
            return "错误";
        }else {
            return "正确";
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Admin admin){
        int result=adminService.update(admin);
        if(result<=0){
            return "error";
        }else {
            return "success";
        }
    }

    @GetMapping("/list")
    public String list(){
        return "admin/list";
    }

    @GetMapping("/query")
    public String query(Admin admin, ModelMap modelMap){
        List<Admin> list= adminService.query(admin);
        modelMap.addAttribute("list",list);
        return "../list.jsp";
    }


    @GetMapping("/query2")
    @ResponseBody
    public List<Admin> query2(Admin admin){
        List<Admin> list= adminService.query(admin);
        return list;
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Admin detail(Integer id){

        return adminService.detail(id);

    }

}
