package com.ql.job.controller;

import com.ql.job.util.XxlHttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wanqiuli
 * @date 2022/4/19 21:49
 */
@RestController
@RequestMapping("/xxl")
public class XxlInvokeController {

    @Resource
    private XxlHttpUtil xxlHttpUtil;

    @GetMapping("/getCookie")
    public String getCookie() {
        return xxlHttpUtil.getCookie();
    }
}
