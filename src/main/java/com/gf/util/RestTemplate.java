package com.gf.util;


import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Map;


public class RestTemplate {
    private static final int connectionTimeOut = 3000;
    private static final int readTimeOut = 3000;

    /**
     * 发送POST请求
     *
     * @param url 请求地址
     * @return
     * @throws Exception
     */
    public static String sendPost(String url, String body, Map<String, String> header) throws Exception {
        //创建httpClient对象
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(url.toString());
        //创建请求设置对象
        RequestConfig requestConfig = null;
        if (1 == 2) {
            //设置代理端口和ip
            HttpHost proxy = new HttpHost("", 1);
            //创建请求设置对象
            requestConfig = RequestConfig.custom()
                    .setProxy(proxy)
                    .setConnectTimeout(connectionTimeOut)
                    .setSocketTimeout(readTimeOut)
                    .build();
        } else {
            requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectionTimeOut)
                    .setSocketTimeout(readTimeOut)
                    .build();
        }
        httpPost.setConfig(requestConfig);
        //添加请求头
        addHeader(httpPost, header);

        //封装请求参数参数，这里必须设置编码格式，不设置的时候会使用服务器默认的，但是可能和目标服务器的编码格式不一致
        if (StringUtils.isNotBlank(body)) {
            StringEntity postEntity = new StringEntity(body, "UTF-8");
            //设置请求参数
            httpPost.setEntity(postEntity);
        }
        //发送请求
        HttpResponse httpResponse = httpClient.execute(httpPost);
        //获取返回的结果
        return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
    }

    public static String sendPostNoProxy(String url, String body, Map<String, String> header) throws Exception {
        //创建httpClient对象
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(url.toString());
        //创建请求设置对象
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectionTimeOut)
                .setSocketTimeout(readTimeOut)
                .build();
        httpPost.setConfig(requestConfig);
        //添加请求头
        addHeader(httpPost, header);

        //封装请求参数参数，这里必须设置编码格式，不设置的时候会使用服务器默认的，但是可能和目标服务器的编码格式不一致
        if (StringUtils.isNotBlank(body)) {
            StringEntity postEntity = new StringEntity(body, "UTF-8");
            //设置请求参数
            httpPost.setEntity(postEntity);
        }
        //发送请求
        HttpResponse httpResponse = httpClient.execute(httpPost);
        //获取返回的结果
        return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
    }

    /**
     * 添加请求头
     *
     * @param http
     * @param header
     * @throws Exception
     */
    public static void addHeader(HttpEntityEnclosingRequestBase http, Map<String, String> header) throws Exception {
        if (header != null && header.size() > 0) {
            for (String key : header.keySet()) {
                http.addHeader(key, header.get(key));
            }
        }
    }

    /**
     * 发送rest请求
     *
     * @param url 请求地址
     * @return
     * @throws Exception
     */
    public static String sendGet(String url) throws Exception {

        HttpClient httpClient = HttpClientBuilder.create().build();
        //设置代理端口和ip
        RequestConfig requestConfig = null;
        if (1 == 2) {
            //设置代理端口和ip
            HttpHost proxy = new HttpHost("", 10);
            //创建请求设置对象
            requestConfig = RequestConfig.custom()
                    .setProxy(proxy)
                    .setConnectTimeout(connectionTimeOut)
                    .setSocketTimeout(readTimeOut)
                    .build();
        } else {
            requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectionTimeOut)
                    .setSocketTimeout(readTimeOut)
                    .build();
        }
        HttpGet httpGet = new HttpGet(url.toString());
        //设置代理
        httpGet.setConfig(requestConfig);
        httpGet.addHeader("Content-Type", "application/json;charset=utf-8");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
    }


    /**
     * 发送rest请求
     *
     * @param url 请求地址
     * @return
     * @throws Exception
     */
    public static String sendGetProxy(String url, String host, int port) throws Exception {

        HttpClient httpClient = HttpClientBuilder.create().build();
        //设置代理端口和ip
        RequestConfig requestConfig = null;

        //设置代理端口和ip
        HttpHost proxy = new HttpHost(host, port);
        //创建请求设置对象
        requestConfig = RequestConfig.custom()
                .setProxy(proxy)
                .setConnectTimeout(connectionTimeOut)
                .setSocketTimeout(readTimeOut)
                .build();

        HttpGet httpGet = new HttpGet(url.toString());
        //设置代理
        httpGet.setConfig(requestConfig);
        httpGet.addHeader("Content-Type", "application/json;charset=utf-8");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
    }

    public static void main(String[] ad) {

    }
}


