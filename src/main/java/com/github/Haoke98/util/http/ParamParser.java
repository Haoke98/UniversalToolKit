package com.github.Haoke98.util.http;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParamParser extends HashMap<String,List<String>> {
    public final static int DATA_TYPE_INT = 0;
    public final static int DATA_TYPE_STRING = 1;

    public ParamParser() {
    }
    public void parse(String paramsStr) throws UnsupportedEncodingException {
        System.out.println(paramsStr);

        paramsStr = URLDecoder.decode(paramsStr,"UTF-8");
        System.out.println(paramsStr);


        String [] paramsArray = paramsStr.split("&");
        for (String s : paramsArray) {
            String[] k_v = s.split("=");
            if(k_v.length>=2){
                List<String> values = this.getOrDefault(k_v[0],new ArrayList<>());
                values.add(k_v[1]);
                this.put(k_v[0],values);
            }else if (k_v.length==1){
                System.out.println("no value for the param:"+k_v[0]);
            }
        }
        System.out.println(this);
    }


    public Integer getIntegerOrDefault(String key, Integer defaultValue){
        return (Integer) getOrDefault(key,defaultValue,DATA_TYPE_INT);
    }
    public String getStringOrDefault(String key,String defaultValue){
        List<String> value_list = super.getOrDefault(key, new ArrayList<String>());
        if(value_list.isEmpty()){
            return defaultValue;
        }else {
            return value_list.get(0);
        }
    }
    public Integer[] getIntegerArrayOrDefault(String key,Integer[] defaultArray){
        List<String> value_list = super.getOrDefault(key, new ArrayList<String>());
        Integer[] res = new Integer[value_list.size()];
        if(value_list.isEmpty()){
            return defaultArray;
        }else{
            for (int i=0;i<value_list.size();i++){
                res[i] = Integer.parseInt(value_list.get(i));
            }
            return res;
        }
    }
    public String[] getStringArrayOrDefault(String key,String[] defaultArray){
        List<String> value_list = super.getOrDefault(key, new ArrayList<String>());
        String[] res = new String[value_list.size()];
        if(value_list.isEmpty()){
            return defaultArray;
        }else{
            for (int i=0;i<value_list.size();i++){
                res[i] = value_list.get(i);
            }
            return res;
        }
    }

    public Object getOrDefault(String key, Object defaultValue,int dataType) {
        List<String> value_list = (List<String>) super.getOrDefault(key, new ArrayList<String>());
        if(value_list.isEmpty()){
            return defaultValue;
        }else {
            return dataFormat(value_list.get(0),dataType);
        }
    }
    public Object[] getOrDefault(String key,Object[] defaultValue,int dataType){
        List<String> value_list = (List<String>) super.getOrDefault(key, new ArrayList<String>());
        if(value_list.isEmpty()){
            return defaultValue;
        }else{
            List<Object> res = new ArrayList<>();
            for (String s:value_list
            ) {
                res.add(this.dataFormat(s,dataType));
            }
            return res.toArray();
        }
    }

    private Object dataFormat(String v,int t){
        switch (t){
            case DATA_TYPE_INT:
                return Integer.parseInt(v);
            case DATA_TYPE_STRING:
                return v;
        }
        return null;
    }
//    @Override
//    public Object getOrDefault(Object key, List<String> defaultValue) {
//        return super.getOrDefault(key, defaultValue);
//    }
}
