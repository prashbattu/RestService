package com.sync.pb.base;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sync.pb.WbtestApplication;

/**
 * Base class for Unit tests
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = WbtestApplication.class)
public abstract class AbstractTest {

    /**
     * The Logger instance for all classes in the unit test framework.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
