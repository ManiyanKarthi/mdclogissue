package org.example;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MDCMain {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(MDCMain.class);

    public static void main(String[] args) {
        log.info("start of application");
        SpringApplication.run(MDCMain.class, args);
    }
}
