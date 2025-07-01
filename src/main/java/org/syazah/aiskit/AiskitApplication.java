package org.syazah.aiskit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableJpaAuditing
public class AiskitApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiskitApplication.class, args);
    }

}
