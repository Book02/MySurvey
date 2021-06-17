package com.shu.utils;

import java.util.HashMap;
import java.util.Map;

public class MapParameter {

    private Map<String,Object> paraMap=new HashMap<>();

    private MapParameter(){

    }

    public static MapParameter getInstance(){
        return new MapParameter();
    }

    public Map<String,Object> getMap(){
        return paraMap;
    }

    public MapParameter put(String key,Object val){
        paraMap.put(key,val);
        return  this;
    }

    public MapParameter put(Map<String,Object> map){
        for(Map.Entry<String,Object> entry: map.entrySet()){
            paraMap.put(entry.getKey(),entry.getValue());
        }
        return  this;
    }

    public MapParameter add(String key,Object val){
        return  this.put(key,val);
    }

    public MapParameter addId(Object val){

        return this.put("id",val);
    }

    public static void main(String[] args) {
        getInstance().put("id",1).getMap();
    }

}
