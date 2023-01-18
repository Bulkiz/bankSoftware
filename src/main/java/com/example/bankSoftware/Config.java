package com.example.bankSoftware;

import com.example.bankSoftware.customThreadPool.ThreadPool;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean
    public ThreadPool customThreadPool() {
        return new ThreadPool(15, 10);
    }

}

