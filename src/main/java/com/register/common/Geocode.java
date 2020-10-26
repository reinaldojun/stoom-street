package com.register.common;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Geocode {

    @JsonProperty("results")
    private List<Result> results = new ArrayList<Result>();
    @JsonProperty("status")
    private String status;

 
}
