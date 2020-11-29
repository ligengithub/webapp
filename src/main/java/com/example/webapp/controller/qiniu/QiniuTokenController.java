package com.example.webapp.controller.qiniu;

import com.example.webapp.exception.MyException;
import com.example.webapp.response.Response;
import com.example.webapp.service.QiniuService;
import com.example.webapp.vo.UploadVo;
import com.qiniu.api.auth.AuthException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ligen
 * @title: QiniuTokenController
 * @projectName webapp
 * @description:
 * @date 2020/11/2816:35
 */

@RestController
@RequestMapping("/qiniu")
public class QiniuTokenController {

    @Autowired
    private QiniuService qiniuService;


    @GetMapping("/getToken")
    public Response getToken() throws AuthException, JSONException {
        return new Response<>(Response.CODE_SUCCESS, QiniuService.getToken());
    }


    @PostMapping("/upLoadImgs")
    public Response upLoadImgs(@RequestBody UploadVo vo) throws MyException {
        return new Response<>(Response.CODE_SUCCESS, qiniuService.upLoadImgs(vo));
    }

    @PostMapping("/getImgs")
    public Response getImgs(@RequestBody UploadVo vo) throws MyException {
        return new Response<>(Response.CODE_SUCCESS, qiniuService.getImgs(vo));
    }

    @PostMapping("/deleteImg")
    public Response deleteImg(@RequestBody UploadVo vo) throws MyException {
        return new Response<>(Response.CODE_SUCCESS, qiniuService.deleteImg(vo));
    }


}
