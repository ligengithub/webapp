package com.example.webapp.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author ligen
 * @title: LoginVo
 * @projectName webapp
 * @description:
 * @date 2020/11/2917:00
 */

@Data
public class LoginVo {

    public interface LOGIN {
    }

    @NotEmpty(groups = {LOGIN.class})
    private String username;
    @NotEmpty(groups = {LOGIN.class})
    private String password;

}
