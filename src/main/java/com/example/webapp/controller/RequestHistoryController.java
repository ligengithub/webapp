package com.example.webapp.controller;

import com.example.webapp.po.RequestHistory;
import com.example.webapp.response.Response;
import com.example.webapp.service.RequestHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * RequestHistory 控制层
 */
@RestController
public class RequestHistoryController {

    @Autowired
    private RequestHistoryService requestHistoryService;


    @PostMapping("/record/add")
    public Response<Boolean> addRecord(HttpServletRequest request) {
        String remoteAddr = request.getHeader("x-real-ip");
        return new Response<>(Response.CODE_SUCCESS, requestHistoryService.insert(new RequestHistory(remoteAddr, new Date())));
    }

    @GetMapping("/record/getRecordCount")
    public Response<Map<String, Integer>> getRecordCount() {
        return new Response<>(Response.CODE_SUCCESS, requestHistoryService.getRecordCount());
    }


}