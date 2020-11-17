package com.gf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public @ResponseBody
    Map test()throws Exception{
        Map map=new HashMap();
        map.put("code","200");
        map.put("message","欢迎你，我的主人，尊贵的刘林先生");
        return map;
    }
}
