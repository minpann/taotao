package com.taotao.controller;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by panmin on 16-9-8.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String getCompanyInfo(HttpServletRequest request)
    {
        Map<String,String> map = new HashMap<String,String>();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        map.put("name",name);
        map.put("password",password);
        return JSONUtils.toJSONString(map);
    }
}
