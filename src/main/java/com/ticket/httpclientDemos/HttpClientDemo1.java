package com.ticket.httpclientDemos;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientDemo1 {
    @Test
    public void httpClientDemo11() throws IOException {
        //定义一个结果参数，result
        String result;
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        //这方法用来执行get方法
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(httpGet);
        result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
        System.out.println(result);
    }
}
