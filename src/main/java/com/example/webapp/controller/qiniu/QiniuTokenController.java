package com.example.webapp.controller.qiniu;

import com.example.webapp.response.Response;
import com.example.webapp.service.QiniuService;
import com.qiniu.api.auth.AuthException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ligen
 * @title: QiniuTokenController
 * @projectName webapp
 * @description:
 * @date 2020/11/2816:35
 */

@RestController
public class QiniuTokenController {

    @GetMapping("/qiniu/getToken")
    public Response getToken() throws AuthException, JSONException {
        return new Response<>(Response.CODE_SUCCESS, QiniuService.getToken());
    }


}
