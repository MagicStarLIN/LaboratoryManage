package com.lcl.labmanage.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: SaticScheduleTask
 * @Description: 定时任务
 * @date 2019/10/25 9:40 上午
 */
@Component
@Configuration
//1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   // 2.开启定时任务
@Slf4j
public class SaticScheduleTask {
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        log.info("执行静态定时任务时间: " + LocalDateTime.now());
    }
}