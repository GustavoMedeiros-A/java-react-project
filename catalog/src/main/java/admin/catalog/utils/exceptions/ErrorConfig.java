package admin.catalog.utils.exceptions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.error.ErrorAttributes;

@Configuration
public class ErrorConfig {

    @Bean
    public ErrorAttributes errorAttributes() {
        return new CustomErrorAttributes();
    }
}