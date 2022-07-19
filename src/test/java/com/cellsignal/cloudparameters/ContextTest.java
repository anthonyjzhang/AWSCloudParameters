package com.cellsignal.cloudparameters;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest (properties = {"FOO=bar"})
class ContextTest{

    @Test
    void contextLoads() {
    }

}