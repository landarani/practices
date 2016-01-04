package net.shahram.practice.camel;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:rest-http.xml", "classpath:inject-bean.xml"
})
public class RestHttpTest {

    @Produce(uri = "direct:restHttp")
    protected ProducerTemplate templateRestHttp;

    @Test
    public void runHttpTest() throws Exception {
        Thread.sleep(5 * 60 * 1000);
    }

}
