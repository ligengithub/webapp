package com.example.webapp;

import com.example.webapp.service.QiniuService;
import com.qiniu.api.auth.AuthException;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebappApplicationTests {

    @Test
    public void contextLoads() throws AuthException, JSONException {
        String token = QiniuService.getToken();
        System.out.println(token);
    }

}
