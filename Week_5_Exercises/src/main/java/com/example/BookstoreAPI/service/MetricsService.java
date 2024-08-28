package com.example.BookstoreAPI.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    private final MeterRegistry meterRegistry;

    public MetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        registerCustomMetrics();
    }

    private void registerCustomMetrics() {
        // Register a custom gauge metric
        meterRegistry.gauge("custom.gauge.book.count", 100); // Replace 100 with dynamic value if needed
    }
}
