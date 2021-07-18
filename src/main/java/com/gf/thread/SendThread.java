package com.gf.thread;

import com.gf.util.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SendThread  extends Thread{


    public static final ExecutorService THREAD_POOL= Executors.newFixedThreadPool(200);
    private String url;
    private String host;
    private  int post;

    public SendThread(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        try {
            String html= RestTemplate.sendGet(url);
            System.out.println("这是获取到的数据"+html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
