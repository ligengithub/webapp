package com.example.webapp.service;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;
import org.json.JSONException;

/**
 * @author ligen
 * @title: QiniuService
 * @projectName webapp
 * @description:
 * @date 2020/11/2816:36
 */
public class QiniuService {


    public static String getToken() throws AuthException, JSONException {

        Config.ACCESS_KEY = "WNpck9WBdrlus0mXhUYSeEVUxGewRJLWWDHcp4o1";
        Config.SECRET_KEY = "hVByGzSINwRNtHaegyezRa-K-QR_PtU1-aOKiM7V";
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        // 请确保该bucket已经存在
        String bucketName = "testlglglg";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        return putPolicy.token(mac);
    }

}
