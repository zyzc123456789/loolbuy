package com.loolbuy.pages.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loolbuy.common.core.Constant;
import com.loolbuy.common.model.ResponseModel;
import com.loolbuy.pages.service.IndexService;
import com.loolbuy.pages.service.LoginService;

@Controller
public class LoginController
{
    @Autowired
    private LoginService loginService;
    
    /**
     * 登录处理
     * 
     * @param request
     * 
     * @return
     */
    @RequestMapping(value="/login.jhtml")
    public String login(HttpServletRequest request, Model model)
    {
        // shiro 认证失败的场合下的例外信息
        String exception = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        
        ResponseModel response = loginService.afterLoginAuth(exception, 1);
        
        model.addAttribute("data", response.getData());
        model.addAttribute("code", response.getCode());
        model.addAttribute("message", response.getMessage());
        
        return "/login";
    }
}
