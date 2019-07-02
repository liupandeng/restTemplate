package com.resttemplate.demo;

import com.resttemplate.demo.Common.AccessTokenInfo;
import com.resttemplate.demo.restTemplate.RunService;
import com.resttemplate.demo.util.MessageHandlerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RunServiceTest {

    @Autowired
    RunService runService;


    MessageHandlerUtil messageHandlerUtil;
    @Test
    public void getTest() throws URISyntaxException {
        runService.getTestGet();
        runService.getTestPost();
        runService.getTestPostParam();
        runService.getTestPut();
        runService.getTestDel();
    }

    @Test
    public void sendMessage() throws URISyntaxException {
        Map<String, String> map = new HashMap<String, String>();
        //发送方帐号
        map.put("FromUserName","loveliupandeng");
        // 开发者微信号
        map.put("ToUserName","loveliupandeng");
        String appId = "wx6f337efdacbc660b";
        String appSecret = "c8cea8aa77eed17e710925291dce8e4a";
        AccessTokenInfo.accessToken = MessageHandlerUtil.getAccessToken(appId, appSecret);
        MessageHandlerUtil.buildTempMessage(map);
    }
}