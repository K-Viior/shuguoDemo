package com.viior.example.shuguodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableAsync
public class ThreadPoolConfigruation {

    @Bean("numberExecutor")
    public ThreadPoolExecutor asyncThreadPoolExcutor(){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//核心线程数量
                10,   //线程池的总数量
                60,   //临时线程空闲时间
                TimeUnit.SECONDS, //临时线程空闲时间的单位
                new ArrayBlockingQueue<>(5),//阻塞队列
                Executors.defaultThreadFactory(),//创建线程的方式
                new ThreadPoolExecutor.AbortPolicy()//任务拒绝策略
        );
        return pool;
    }
}
