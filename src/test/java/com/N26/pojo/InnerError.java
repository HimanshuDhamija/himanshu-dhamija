package com.N26.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InnerError {

    @JsonProperty("code")
    Integer code;
    @JsonProperty("type")
    String type;
    @JsonProperty("message")
    String message;
}
