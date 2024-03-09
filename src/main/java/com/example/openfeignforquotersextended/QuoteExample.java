package com.example.openfeignforquotersextended;

public record QuoteExample(String type, QuoteValue value) {
    @Override
    public String toString() {
        return value.toString();
    }
}
