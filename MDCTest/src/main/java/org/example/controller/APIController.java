package org.example.controller;

import brave.ScopedSpan;
import brave.Tracer;
import lombok.AllArgsConstructor;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class APIController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(APIController.class);
    @Autowired
    private Tracer tracer;

    @PostMapping(value = "/mdclog")
    public Mono<ResponseEntity<String>> processJmlEvent(@RequestBody String payload) {
        return Mono.just(payload)
                .doOnNext(payload1->log.info("{}", MDC.getMap().keySet()))
                .map(out->ResponseEntity.accepted().body(payload));
    }
}
