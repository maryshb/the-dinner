package thedinnerapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "thedinnerapp.controllers",
        "thedinnerapp.services.impl",
        "thedinnerapp.session"
})
public class TestConfiguration {
}
