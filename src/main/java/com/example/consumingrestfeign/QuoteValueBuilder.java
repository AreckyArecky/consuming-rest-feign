package com.example.consumingrestfeign;

public final class QuoteValueBuilder {
    long id;
    String quote;

    public QuoteValueBuilder(long id, String quote){
        this.id = id;
        this.quote  = quote;
    }
    public QuoteValueBuilder(String quote){
        this.quote = quote;
    }

    public QuoteValue build(){
        return new QuoteValue(id, quote);
    }
}
