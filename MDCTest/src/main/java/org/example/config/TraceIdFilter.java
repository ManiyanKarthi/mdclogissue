package org.example.config;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

;

@Configuration
public class TraceIdFilter implements WebFilter {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TraceIdFilter.class);
    @Autowired
    private Tracer tracer;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        log.info("Inside filter {}", MDC.getMap().keySet());
        return chain
                .filter(exchange);
    }
}
