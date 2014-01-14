package com.springmvc.test.controller;

import com.springmvc.test.common.util.RandomVerificationUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class VerificationController {

    @RequestMapping(value = "getVerificationImage",method = {RequestMethod.GET})
    public void getVerificationImage(HttpServletRequest request, HttpServletResponse response){

        setResponse(response);
        RandomVerificationUtil randomValidateCode = new RandomVerificationUtil();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setResponse(HttpServletResponse response) {
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
    }
}
