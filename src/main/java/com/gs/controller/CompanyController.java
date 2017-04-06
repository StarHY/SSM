package com.gs.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/4/1.
 */
@Controller
@RequestMapping("company")
public class CompanyController {

    private Logger logger = (Logger) LoggerFactory.getLogger(CompanyController.class);

    @RequestMapping(value = "home", method = RequestMethod.GET)
    private String home() {
        logger.info("访问公司的主页");
        return "company/home";
    }
}
