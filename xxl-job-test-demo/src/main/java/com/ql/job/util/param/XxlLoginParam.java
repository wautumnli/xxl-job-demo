package com.ql.job.util.param;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wanqiuli
 * @date 2022/4/19 21:34
 */
@Data
@Component
@ConfigurationProperties(prefix = "xxl.login")
public class XxlLoginParam {

    private String username;
    private String password;
}
