package com.example.consumingrestfeign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Quote(String type, QuoteValue value) {
}
