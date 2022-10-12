package com.jjh.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class AppTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(context);
    }

    @Test
    public void checkAllBeansLoaded() {
        int totalbeans = this.context.getBeanDefinitionCount();
        Assertions.assertEquals(
                45,
                totalbeans,
                "There should be 45 beans loaded");
    }

}