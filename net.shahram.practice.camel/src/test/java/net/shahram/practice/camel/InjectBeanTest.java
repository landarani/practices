package net.shahram.practice.camel;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:inject-bean.xml")
public class InjectBeanTest {

    @Produce(uri = "direct:service1")
    protected ProducerTemplate template1;

    @Produce(uri = "direct:service2")
    protected ProducerTemplate template2;

    @EndpointInject(uri = "mock:result")
    private MockEndpoint resultEndpoint;

    @Before
    public void setup() {
        resultEndpoint.reset();
        resultEndpoint.whenAnyExchangeReceived(new Processor() {

            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("running mock:result");
            }
        });
        resultEndpoint.expectedBodyReceived().body();
    }

    @Test
    public void runTest1() throws Exception {
        String body = "Hello Service1";
        resultEndpoint.expectedBodiesReceived(body);
        template1.sendBody(body);
        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void runTest2() throws Exception {
        String body = "Hello Service2";
        resultEndpoint.expectedBodiesReceived(body);
        template2.sendBody(body);
        resultEndpoint.assertIsSatisfied();
    }
}
