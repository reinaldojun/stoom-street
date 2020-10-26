
package com.register.common;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Result {

    @JsonProperty("address_components")
    private List<AddressComponent> addressComponents = new ArrayList<AddressComponent>();
    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("place_id")
    private String placeId;
    @JsonProperty("types")
    private List<String> types = new ArrayList<String>();

}
