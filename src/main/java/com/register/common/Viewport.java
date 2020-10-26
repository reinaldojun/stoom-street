package com.register.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Viewport {

    @JsonProperty("northeast")
    private Northeast northeast;
    @JsonProperty("southwest")
    private Southwest southwest;

 
}
