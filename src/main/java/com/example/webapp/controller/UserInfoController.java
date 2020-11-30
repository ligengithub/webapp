package com.example.webapp.controller;

import com.example.webapp.exception.MyException;
import com.example.webapp.response.Response;
import com.example.webapp.service.UserInfoService;
import com.example.webapp.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserInfo 控制层
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public Response login(@RequestBody @Validated({LoginVo.LOGIN.class}) LoginVo userInfo) throws MyException {
        return new Response<>(Response.CODE_SUCCESS, userInfoService.login(userInfo));
    }

}