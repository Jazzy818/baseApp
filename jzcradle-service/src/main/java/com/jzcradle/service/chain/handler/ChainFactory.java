package com.jzcradle.service.chain.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

// 这里不能直接用@Component注入，因为不同的T,R会生成不同的Bean
public class ChainFactory<T, R> {
    private IHandler<T, R> firstHandler;

    public ChainFactory(List<IHandler<T, R>> handlerList) {
        if (handlerList == null || handlerList.isEmpty()) {
            throw new IllegalArgumentException("handlerList 不能为空");
        }
        for (int i = 0; i < handlerList.size() - 1; i++) {
            handlerList.get(i).setNextHandler(handlerList.get(i + 1));
        }
        firstHandler = handlerList.get(0);
    }

    public R execute(T context) {
        return firstHandler.handle(context);
    }


}
