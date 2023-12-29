package com.example.consumingrestfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("quotes-client")
public interface QuoteClient {
    @GetMapping("/apiWithRequestParam")
    Quote makeSearchRequestWithParam(@RequestParam("id") String id);

    @GetMapping("/apiWithHeader")
    List<Quote> makeSearchRequestWithHeader(@RequestHeader String requestId);

    @PostMapping("/api/quote")
    Quote addQuote(@RequestBody QuoteValue quote);

    @DeleteMapping("/api/quote/{quoteId}")
    void deleteQuoteById(@PathVariable String quoteId);

}
