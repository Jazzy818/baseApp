package com.jzcradle.service.chain.handler;


import com.jzcradle.api.response.Result;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class ProAChainHandler extends AbstractHandler<ProContext, Result> {

    @Override
    public Result handle(ProContext t) {
        System.out.println("ProAChainHandler handle : " + t.getChannel());
        return super.handle(t);
    }
}
