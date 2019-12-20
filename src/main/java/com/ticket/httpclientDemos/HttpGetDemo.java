package com.ticket.httpclientDemos;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HttpGetDemo {
    private String url;
    private ResourceBundle resourceBundle;//获取properties文件参数

    @BeforeTest
    public void beforeTest(){
        resourceBundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url = resourceBundle.getString("test.ip");
    }
    @Test
    public void testDemo() throws IOException {
        String result;
        String testurl = this.url + resourceBundle.getString("test.url");
        HttpGet httpGet = new HttpGet(testurl);
        HttpClient  httpClient = new DefaultHttpClient();
       HttpResponse httpResponse = httpClient.execute(httpGet);
       result =  EntityUtils.toString(httpResponse.getEntity());
        System.out.println(result);
    }
}
