package com.jzcradle.service.chain.handler;

import com.jzcradle.api.response.Result;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class ProBChainHandler extends AbstractHandler<ProContext, Result> {

    @Override
    public Result handle(ProContext t) {
        System.out.println("ProBChainHandler handle:" + t.getChannel());
        return super.handle(t);
    }
}
