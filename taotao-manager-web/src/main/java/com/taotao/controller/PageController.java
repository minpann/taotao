package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by panmin on 16-8-27.
 */
@Controller
public class PageController {

    /**
     * 打开首页
     */
    @RequestMapping(value = "/")
    public String showIndex()
    {
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page)
    {
        return page;
    }

}
