package com.example.openfeignforquotersextended;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
public record QuoteValue(Long id, String quote) {
}