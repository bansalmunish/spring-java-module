package com.example.commons.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {

    private boolean success;
    private String code;
    private String description;
}
