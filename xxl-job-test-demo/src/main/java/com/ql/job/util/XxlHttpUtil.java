package com.ql.job.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.ql.job.util.param.XxlConstant;
import com.ql.job.util.param.XxlLoginParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanqiuli
 * @date 2022/4/19 21:40
 */
@Slf4j
@Component
public class XxlHttpUtil {

    @Value("${xxl.job.admin.addresses}")
    private String baseUrl;

    @Resource
    private XxlLoginParam xxlLoginParam;

    /**
     * 获取cookie
     *
     * @return the {@link String} data
     */
    public String getCookie() {
        String url = baseUrl + XxlConstant.URL_LOGIN;
        log.info(JSON.toJSONString(xxlLoginParam));
        Map<String, Object> loginMap = new HashMap<>();
        loginMap.put("userName", xxlLoginParam.getUsername());
        loginMap.put("password", xxlLoginParam.getPassword());
        HttpResponse response = HttpRequest.post(url).form(loginMap).execute();
        boolean ok = response.isOk();
        if (ok) {
            List<HttpCookie> cookies = response.getCookies();
            log.info("获取xxl cookie成功,返回信息:{}", cookies);
            StringBuilder sb = new StringBuilder();
            for (HttpCookie cookie : cookies) {
                sb.append(cookie.toString());
            }
            return sb.toString();
        }
        log.error("调用xxl获取cookie失败:{}", JSON.parseObject(response.body()));
        throw new RuntimeException("xxl 获取 cookie失败");
    }
}
