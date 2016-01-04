package net.shahram.practice.camel;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.apache.camel.Properties;
import org.apache.camel.Property;

import java.util.Map;

@Slf4j
public class StagedProcessor {

    public void handleBefore(@Body Object body, @Property("serviceBean") StagedService bean, @Properties Map<String, Object> props) throws Exception {
        log.info("Before handling [{}]", body);
        bean.doBefore();
    }

    public void handleAfter(@Body Object body, @Property("serviceBean") StagedService bean) throws Exception {
        log.info("After handling [{}]", body);
        bean.doAfter();
    }

    @Handler
    public void handle(@Body Object body) throws Exception {
        log.info("getting in handler :) {}", body);
    }
}
