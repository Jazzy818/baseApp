package com.jzcradle.service.chain.handler;

import com.jzcradle.api.response.Result;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChainConfig {

    @Bean
    public ChainFactory<ProContext, Result> proChainFactory(List<IHandler<ProContext, Result>> proHandlers) {
        return new ChainFactory<>(proHandlers);
    }

    @Bean
    public ChainFactory<FunContext, Result> funChainFactory(List<IHandler<FunContext, Result>> funHandlers) {
        return new ChainFactory<>(funHandlers);
    }
}
