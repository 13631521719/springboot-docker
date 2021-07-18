package com.gf.controller;

import com.gf.protobuf.AddressBookOuterClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        map.put("message","欢迎你，尊贵的刘林先生");
        map.put("ip",getIp());
        map.put("timestemp",new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(new Date()));
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


    public static void main(String[] args) {
        AddressBookOuterClass.AddressBook .Builder  addressBook= AddressBookOuterClass.AddressBook .newBuilder();
        AddressBookOuterClass.Person .Builder  person= AddressBookOuterClass.Person .newBuilder();
        person.setName("Mike");
        person.setEmail("Email");

        addressBook.setPerson(1,person);

        AddressBookOuterClass.Person.PhoneNumber.Builder phoneNum=AddressBookOuterClass.Person.PhoneNumber.newBuilder();
        phoneNum.setNumber("12314444");
        phoneNum.setType(AddressBookOuterClass.Person.PhoneType.HOME);
        person.setPhone(4,phoneNum);

    }
}
