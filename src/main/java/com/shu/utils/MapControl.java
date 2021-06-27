package com.shu.utils;

import java.util.HashMap;
import java.util.Map;

public class MapControl {

    private Map<String,Object> paraMap=new HashMap<>();

    public  static  int SUCCESS_CODE=200;
    public  static  int ERROR_CODE=500;
    private MapControl(){

    }

    public static MapControl getInstance(){
        return new MapControl();
    }

    public Map<String,Object> getMap(){
        return paraMap;
    }

    public MapControl put(String key, Object val){
        paraMap.put(key,val);
        return  this;
    }

    public MapControl put(Map<String,Object> map){
        for(Map.Entry<String,Object> entry: map.entrySet()){
            paraMap.put(entry.getKey(),entry.getValue());
        }
        return  this;
    }

    public MapControl add(String key, Object val){
        return  this.put(key,val);
    }

    public MapControl addId(Object val){

        return this.put("id",val);
    }

    public MapControl success(){
        return this.put("msg","操作成功").put("code",SUCCESS_CODE);
    }
    public MapControl error(){
        return this.put("msg","操作失败").put("code",ERROR_CODE);
    }

    public MapControl success(String str){
        return this.put("msg",str).put("code",SUCCESS_CODE);
    }
    public MapControl error(String str){
        return this.put("msg",str).put("code",ERROR_CODE);
    }
    

    public static void main(String[] args) {
        getInstance().put("id",1).getMap();
    }

}
