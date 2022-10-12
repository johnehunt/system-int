package com.jjh.beans;

import com.jjh.main.AppConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = { AppConfig.class} )
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { AppConfig.class} )
public class CalculatorServiceImplTest {

    public CalculatorServiceImplTest() {}

    @Autowired
    private CalculatorService calculator;

    @BeforeAll
    static void setUpBeforeClass()  {
        System.out.println("setUpBeforeClass");
    }
    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("tearDownAfterClass");
    }

    @BeforeEach
    public void setUp()  {
        System.out.println("In setup");
    }

    @AfterEach
    public void tearDown()  {
        System.out.println("In tearDown");
    }

    @Test
    public void add() {
        calculator.add(1);
        calculator.add(1);
        Assertions.assertEquals(2, calculator.value(), "Result of add into 1 + 1 should be 2");
    }

    @Test
    public void clear() {
        calculator.add(1);
        calculator.add(1);
        calculator.clear();
        Assertions.assertEquals(0.0, calculator.value(), "Clear should give Zero");
    }

    @Disabled("not ready yet")
    @Test
    public void subtract() {
        calculator.add(2);
        calculator.subtract(5);
        Assertions.assertEquals(10.0, calculator.value(), "Testing result of subtraction");
    }

}
