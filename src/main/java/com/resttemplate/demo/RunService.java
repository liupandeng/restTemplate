package com.resttemplate.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class RunService {

    @Autowired
    private RestTemplate restTemplate;

    private static String GET_URL = "http://localhost:8080/testGet";
    private static String POST_URL = "http://localhost:8080/testPost";
    private static String POST_PARAM_URL = "http://localhost:8080/testPostParam";
    private static String PUT_URL = "http://localhost:8080/testPut";
    private static String DEL_URL = "http://localhost:8080/testDel";

    /**
     * 调用Get接口
     * 实现了三种方式调用
     * @throws URISyntaxException
     */
    @GetMapping("getTestGet")
    public void getTestGet() throws URISyntaxException {

        //1、通过getForObject()调用
        TestEntity testEntity1 = this.restTemplate.getForObject(GET_URL, TestEntity.class);
        System.out.println("get testEntity1:"+testEntity1);

        //2、通过getForEntity()调用
        ResponseEntity<TestEntity> responseEntity1 = this.restTemplate.getForEntity(GET_URL, TestEntity.class);
        HttpStatus statusCode = responseEntity1.getStatusCode();
        HttpHeaders header = responseEntity1.getHeaders();
        TestEntity testEntity2 = responseEntity1.getBody();
        System.out.println("get testEntity2:"+testEntity2);
        System.out.println("get statusCode:"+statusCode);
        System.out.println("get header:"+header);

        //3、通过exchange()调用
        RequestEntity requestEntity = RequestEntity.get(new URI(GET_URL)).build();
        ResponseEntity<TestEntity> responseEntity2 = this.restTemplate.exchange(requestEntity, TestEntity.class);
        TestEntity testEntity3 = responseEntity2.getBody();
        System.out.println("get testEntity3:"+testEntity3);

    }

    /**
     * 调用Post接口
     * 实现了三种方式调用
     * @throws URISyntaxException
     */
    @GetMapping("getTestPost")
    public void getTestPost() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        String data = new String();
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);

        //1、通过postForObject()调用
        TestEntity testEntity1 = this.restTemplate.postForObject(POST_URL,formEntity, TestEntity.class);
        System.out.println("post testEntity1:"+testEntity1);

        //2、通过postForEntity()调用
        ResponseEntity<TestEntity> responseEntity1 = this.restTemplate.postForEntity(POST_URL, formEntity,TestEntity.class);
        HttpStatus statusCode = responseEntity1.getStatusCode();
        HttpHeaders header = responseEntity1.getHeaders();
        TestEntity testEntity2 = responseEntity1.getBody();
        System.out.println("post testEntity2:"+testEntity2);
        System.out.println("post statusCode:"+statusCode);
        System.out.println("post header:"+header);

        //3、通过exchange()调用
        RequestEntity requestEntity = RequestEntity.post(new URI(POST_URL)).body(formEntity);
        ResponseEntity<TestEntity> responseEntity2 = this.restTemplate.exchange(requestEntity, TestEntity.class);
        TestEntity testEntity3 = responseEntity2.getBody();
        System.out.println("post testEntity3:"+testEntity3);
    }


    /**
     * 调用Post接口，并传递了参数
     */
    @GetMapping("getTestPostParam")
    public void getTestPostParam(){
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("id", "100");
        map.add("name", "getTestPostParam");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);


        String data = restTemplate.postForObject(POST_PARAM_URL,request,String.class);
        System.out.println("getTestPostParam data: "+ data);
        System.out.println("getTestPostParam succ");
    }

    /**
     * 调用Put接口
     */
    @GetMapping("getTestPut")
    public void getTestPut(){

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("id", "101");
        map.add("name", "getTestPut");
        restTemplate.put(PUT_URL,map);
        System.out.println("getTestPut succ");
    }

    /**
     * 调用Del接口
     */
    @GetMapping("getTestDel")
    public void getTestDel(){

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("id", "101");
        map.add("name", "getTestPut");

        restTemplate.delete(DEL_URL,map);
    }
}