package net.shahram.practice.camel;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@AllArgsConstructor
public class ResponseObject {
    @JsonProperty("Code")
    String responseCode;
    @JsonProperty("Description")
    String responseDescription;
}
