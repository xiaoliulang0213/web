package com.liuxiaonian;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

public class CxfClient {
    public static void main(String[] args) throws IOException {
        //创建WebClient
        WebClient client = WebClient.create("http://www.baidu.com");
        //获取响应
        Response response = client.get();
        //获取响应的内容
        InputStream inputStream = (InputStream) response.getEntity();
        String content = IOUtils.readStringFromStream(inputStream);
        System.err.println(content);
    }
}
