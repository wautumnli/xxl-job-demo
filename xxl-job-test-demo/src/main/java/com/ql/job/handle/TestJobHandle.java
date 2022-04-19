package com.ql.job.handle;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author wanqiuli
 * @date 2022/4/19 20:16
 */
@Slf4j
@Component
public class TestJobHandle {

    /**
     * xxl-job 一般定时任务demo
     */
    @XxlJob("firstDemoHandle")
    public void firstDemoHandle() throws InterruptedException {
        String jobParam = XxlJobHelper.getJobParam();
        log.info("param: {}", jobParam);
        XxlJobHelper.log("XXL-JOB, Hello first!");
        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
