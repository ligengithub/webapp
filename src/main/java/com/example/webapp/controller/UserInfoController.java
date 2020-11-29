package com.example.webapp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.webapp.domain.po.UserInfo;
import com.example.webapp.response.Response;
import com.example.webapp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * UserInfo 控制层
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public Response login(@RequestBody UserInfo userInfo) {

        UserInfo user = userInfoService.selectOne(new EntityWrapper<>(new UserInfo().setUsername(userInfo.getUsername())));

        if (user == null) {
            userInfoService.addUser(userInfo);
            return new Response<>(Response.CODE_SUCCESS, userInfo);
        } else {
            if (StringUtils.pathEquals(user.getPassword(), userInfo.getPassword())) {
                return new Response<>(Response.CODE_SUCCESS, user);
            } else {
                return new Response<>(Response.CODE_FAIL, "登录失败，密码错误");
            }
        }
    }

}