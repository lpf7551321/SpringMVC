package com.netease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;


/**
 * Created by miracler on 4/17/16.
 */
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:applicationContext-Test.xml")
public abstract class AbstractTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    WebApplicationContext webApplicationContext;
}
