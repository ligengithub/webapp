package com.example.webapp.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.webapp.domain.dto.ImgInfo;
import com.example.webapp.domain.po.UserImg;
import com.example.webapp.exception.MyException;
import com.example.webapp.domain.po.UserInfo;
import com.example.webapp.vo.UploadVo;
import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.nio.cs.US_ASCII;

import java.util.List;

/**
 * @author ligen
 * @title: QiniuService
 * @projectName webapp
 * @description:
 * @date 2020/11/2816:36
 */

@Service
public class QiniuService {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserImgService userImgService;


    public static String getToken() throws AuthException, JSONException {

        Config.ACCESS_KEY = "WNpck9WBdrlus0mXhUYSeEVUxGewRJLWWDHcp4o1";
        Config.SECRET_KEY = "hVByGzSINwRNtHaegyezRa-K-QR_PtU1-aOKiM7V";
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        // 请确保该bucket已经存在
        String bucketName = "testlglglg";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        return putPolicy.token(mac);
    }

    /**
     * 上传图片
     */
    public boolean upLoadImgs(UploadVo vo) throws MyException {

        UserInfo userInfo = checkUser(vo);

        vo.getImages().forEach(imgInfo -> {
            UserImg userImg = new UserImg()
                    .setUserId(userInfo.getId())
                    .setImgUid(imgInfo.getImgUid())
                    .setImgName(imgInfo.getImgName())
                    .setImageUrl(imgInfo.getImgUrl());
            userImgService.insert(userImg);
        });
        return true;
    }

    /**
     * 获取图片
     */
    private UserInfo checkUser(UploadVo vo) throws MyException {

        UserInfo userInfo = userInfoService.selectOne(new EntityWrapper<>(new UserInfo().setUsername(vo.getUsername())
                .setPassword(vo.getPassword())));
        if (userInfo == null) {
            throw new MyException(MyException.CODE_AUTH_ERROR);
        } else {
            return userInfo;
        }
    }

    public List<UserImg> getImgs(UploadVo vo) throws MyException {
        UserInfo userInfo = checkUser(vo);
        return userImgService.selectList(new EntityWrapper<>(new UserImg().setUserId(userInfo.getId())));
    }

    // TODO
    public boolean deleteImg(UploadVo vo) throws MyException {
        UserInfo userInfo = checkUser(vo);

        UserImg img = userImgService.selectOne(new EntityWrapper<>(new UserImg().setImgUid(vo.getImgUid())));

        if (img == null || !img.getUserId().equals(userInfo.getId())) {
            throw new MyException(MyException.CODE_UNKNOWN_ERROR);
        } else {
            return userImgService.delete(new EntityWrapper<>(new UserImg().setImgUid(vo.getImgUid())));
        }
    }
}
