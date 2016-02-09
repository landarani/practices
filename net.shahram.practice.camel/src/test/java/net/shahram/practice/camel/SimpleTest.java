package net.shahram.practice.camel;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:simple.xml")
public class SimpleTest {

    @Produce(uri = "direct:startSimple")
    protected ProducerTemplate template1;

    @EndpointInject(uri = "mock:result")
    private MockEndpoint resultEndpoint;

    @Before
    public void setup() {
        resultEndpoint.reset();
        resultEndpoint.expectedBodyReceived().body();
    }

    @Test
    public void runTest1() throws Exception {
        String body = "Body1";
        resultEndpoint.expectedBodiesReceived(body);
        template1.sendBodyAndHeader(body, "JMSType", "CLIMATE_SETTING_ACKNOWLEDGMENT");
        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void runTest2() throws Exception {
        String body = "Body2";
        resultEndpoint.expectedBodiesReceived(body);
        template1.sendBodyAndHeader(body, "JMSType", "CLIMATE_SETTING_ACKNOWLEDGEMENT");
        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void runTest3() throws Exception {
        String body = "Body3";
        resultEndpoint.expectedBodiesReceived(body);
        try {
            template1.sendBodyAndHeader(body, "JMSType", "CLIMATE_ACKNOWLEDGEMENT");
            throw new AssertionError("Test is not expected to pass successfully.");
        } catch (Exception x) {
            assertEquals("Header is not recognized", x.getCause().getMessage());
        }
    }

    @Test
    public void runTest4() throws Exception {
        String body = "Body4";
        resultEndpoint.expectedBodiesReceived(body);
        Map<String, Object> headers = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;

            {
                put("JMSType", "CLIMATE_ACKNOWLEDGEMENT");
                put("C", Boolean.TRUE);
            }
        };
        template1.sendBodyAndHeaders(body, headers);
        resultEndpoint.assertIsSatisfied();
    }
}
