package com.example.bankSoftware;

import com.example.bankSoftware.customThreadPool.ThreadPool;
import com.example.bankSoftware.dtos.TransactionDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


@Configuration
public class Config {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean
    public ThreadPool customThreadPool() {
        return new ThreadPool(10, 10);
    }

    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(15);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(false);
        executor.initialize();

        return executor;
    }
}
