package com.shu.service;

import com.shu.entity.Admin;
import com.shu.mapper.AdminDao;
import com.shu.utils.BeanMapUtils;
import com.shu.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    //?为什么不用map
    public int create(Admin pi){
        return adminDao.create(pi);
    }

    public int delete(Integer id){
      return adminDao.delete(MapParameter.getInstance().addId(id).getMap());
    }

    public int update(Admin admin){
        return  adminDao.update(MapParameter.getInstance().put( BeanMapUtils.beanToMapForUpdate(admin)).addId(admin.getId()).getMap());
    }

    public List<Admin> query(Admin admin){
        return  adminDao.query(MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(admin)).getMap());
    }

    public Admin detail(Integer id){

        return adminDao.detail(MapParameter.getInstance().addId(id).getMap());

    }

    public int count(Admin admin){

        return  adminDao.count(MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(admin)).getMap());
    }

    /**
     * 管理员登录
     * @param account
     * @param password
     * @return
     */
    public Admin login(String account,String password){
        Map<String, Object> map = MapParameter.getInstance().add("account",account).add("password",password).getMap();
        return adminDao.detail(map);
    }

}
