package com.loolbuy.pages.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loolbuy.pages.service.IndexService;

@Controller
public class IndexCotroller
{
    @Autowired
    private IndexService indexService;
    
    @RequestMapping(value = "/test/test.ahtml")
    public ModelAndView init(HttpServletRequest request) {

        ModelAndView model = new ModelAndView();

        // 设置视图
        model.setViewName("indexjsp");

        return model;
    }
}
