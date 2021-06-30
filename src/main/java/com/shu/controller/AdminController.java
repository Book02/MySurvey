package com.shu.controller;

import com.shu.entity.Admin;
import com.shu.service.AdminService;
import com.shu.utils.MapControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    @PostMapping("/query")
    @ResponseBody
    public Map<String,Object> query(@RequestBody Admin admin, ModelMap modelMap){
        System.out.println(admin.getPage());
        System.out.println(admin.getLimit());
        System.out.println(admin.getAccount());
        List<Admin> list = adminService.query(admin);
        Integer count = adminService.count(admin);
        return MapControl.getInstance().page(list,count).getMap();
    }




    @PostMapping("/detail")
    @ResponseBody
    public Admin detail(Integer id){

        return adminService.detail(id);

    }

}
