package com.gf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @Value("${key1}")
    private String key1;

    @Value("${key2}")
    private String key2;

    @RequestMapping(value = "/test")
    public @ResponseBody
    Map test()throws Exception{
        Map map=new HashMap();
        map.put("code","200");
        map.put("message","欢迎你，我的主人，尊贵的刘林先生");
        map.put("ip",getIp());
        map.put("timestemp",new SimpleDateFormat("YYYY-MM-DD HH:mm:ss"));
        return map;
    }


    public static String getIp(){
        try {
            InetAddress ia= InetAddress.getLocalHost();
//        String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            return localip;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "500";
        }
    }
}
