package net.shahram.practice.camel;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

@Slf4j
public class RestProcessor {

    public Integer process(Integer request) {
        log.info("Received [{}]", request);
        return 0;
    }

    public ResponseObject respond(Integer code) throws Exception {
        ResponseObject response = null;
        if (code == 0) {
            response = new ResponseObject(String.valueOf(code), "Message successfully processed.");
        } else {
            throw new IllegalStateException("what are you doing here?");
        }
        log.info("Returning response: [{}]", response);

        return response;
    }

    public ResponseObject makeError() {
        return new ResponseObject(String.valueOf(1), "Unrecognized code.");
    }

    public String toJson(Object object) throws IOException {
        return new ObjectMapper().writeValueAsString(object);
    }
}
