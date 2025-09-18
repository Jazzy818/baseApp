package com.jzcradle.service.chain.handler;

import com.jzcradle.api.response.Result;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class FunAChainHandler extends AbstractHandler<FunContext, Result> {

    @Override
    public Result handle(FunContext t) {
        System.out.println("FunAChainHandler handle:" + t.getChannel());
        return super.handle(t);
    }
}
