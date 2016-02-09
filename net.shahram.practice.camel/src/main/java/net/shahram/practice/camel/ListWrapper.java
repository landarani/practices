package net.shahram.practice.camel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter(AccessLevel.NONE)
public class ListWrapper {

    @JsonProperty(value = "FG.SerialNo")
    private String serialNo;

    @JsonProperty(value = "Subscriptions")
    private List<String> subscriptions;
}
