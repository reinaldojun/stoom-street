
package com.register.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Southwest {

    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lng")
    private Double lng;

}
