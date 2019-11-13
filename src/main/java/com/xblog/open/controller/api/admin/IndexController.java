package com.xblog.open.controller.api.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页入口
 * @Author guodandan
 * @Date 2018/9/10 22:18
 */
@Controller
@RequestMapping("/api/admin")
public class IndexController {

    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String index(){
        return "admin/index";
    }
}
