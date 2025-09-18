package com.jzcradle.service.chain.handler;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChainTest {


    @Resource
    private ChainFactory funChainFactory;

    @Resource
    private ChainFactory proChainFactory;

    @Test
    public void testSpringChainManager() {
        funChainFactory.execute(new FunContext());
        System.out.println("-------------------");
        proChainFactory.execute(new ProContext());

    }


}
