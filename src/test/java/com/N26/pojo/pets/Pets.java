
package com.N26.pojo.pets;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pets {

    @JsonProperty("id")
    Long id;
    @JsonProperty("category")
    Category category;
    @JsonProperty("name")
    String name;
    @JsonProperty("photoUrls")
    List<String> photoUrls;
    @JsonProperty("tags")
    List<Tag> tags;
    @JsonProperty("status")
    String status;

}
