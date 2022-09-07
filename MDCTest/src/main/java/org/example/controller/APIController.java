package org.example.controller;

import lombok.AllArgsConstructor;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
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

    @PostMapping(value = "/mdclog")
    public Mono<ResponseEntity<String>> processJmlEvent(@RequestBody String payload) {

        log.info("{}", MDC.getMap().keySet());

        return null;
    }
}
