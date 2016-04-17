package com.netease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by miracler on 4/17/16.
 */
@Test
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public abstract class AbstractTest extends AbstractTestNGSpringContextTests {

}
