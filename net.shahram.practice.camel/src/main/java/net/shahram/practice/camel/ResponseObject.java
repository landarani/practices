package net.shahram.practice.camel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseObject {
    String responseCode;
    String responseDescription;
}
