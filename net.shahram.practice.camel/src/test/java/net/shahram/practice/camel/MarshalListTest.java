package net.shahram.practice.camel;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:marshal-list.xml")
public class MarshalListTest {
    public static final String SERIAL_NO = "36000000001";

    @Produce(uri = "direct:startAllInOne")
    protected ProducerTemplate templateAllInOne;

    @Produce(uri = "direct:startSplit")
    protected ProducerTemplate templateSplit;

    @Produce(uri = "direct:startSimple")
    protected ProducerTemplate templateSimple;

    @Test
    public void runAllInOneTest() {
        templateAllInOne.sendBody(SERIAL_NO);
    }

    @Test
    public void runSplitTest() {
        templateSplit.sendBody(SERIAL_NO);
    }

    @Test
    public void runSimpleSplit() {
        templateSimple.sendBody(SERIAL_NO);
    }
}
