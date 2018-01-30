package com.liuxiaonian;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestletClient {
    public static void main(String[] args) throws IOException {
        ClientResource clientResource = new ClientResource("http://www.baidu.com");
        //调用get（）则发送的请求是get
        Representation representation = clientResource.get(MediaType.APPLICATION_JSON);
        //创建JacksonRepersentation实例，将响应转化为Map
        JacksonRepresentation jacksonRepresentation =
                new JacksonRepresentation(representation, HashMap.class);
        //获取转换后的Map对象
        Map result = (HashMap) jacksonRepresentation.getObject();
        //输出结果
        System.err.println(result.get("id")+"-"+result.get("name")+"-"+
            result.get("age")+"-"+result.get("message"));

    }
}
