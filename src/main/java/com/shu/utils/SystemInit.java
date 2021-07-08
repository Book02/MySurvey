package com.shu.utils;

import com.shu.entity.Admin;
import com.shu.mapper.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemInit {

    @Autowired
    private AdminDao adminDao;

    public static Map<Integer,Admin> adminMap = new HashMap<>();

    public void init(){
        List<Admin> list = adminDao.query(null);
        for (Admin admin : list) {
            adminMap.put(admin.getId(),admin);
        }
        System.out.println("初始化加载数据..."+adminMap);
    }

}
