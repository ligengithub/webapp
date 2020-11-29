package com.example.webapp.vo;

import com.example.webapp.domain.dto.ImgInfo;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author ligen
 * @title: UploadVo
 * @projectName webapp
 * @description:
 * @date 2020/11/2910:42
 */
@Data
public class UploadVo {

    public static interface ADD {
    }

    public static interface GET {
    }

    public static interface DELETE {

    }

    @NotEmpty(groups = {ADD.class, GET.class})
    private String username;

    @NotEmpty(groups = {ADD.class, GET.class})
    private String password;

    @NotEmpty(groups = {ADD.class})
    private List<ImgInfo> images;

    @NotEmpty(groups = {DELETE.class})
    private String imgUid;


}
