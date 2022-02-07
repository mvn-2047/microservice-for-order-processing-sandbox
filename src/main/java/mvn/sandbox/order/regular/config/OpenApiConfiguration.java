package mvn.sandbox.order.regular.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI openAPI(@Value("${application.api.title:Title not provided}") String appTitle,
                           @Value("${application.api.description:good application}") String appDescription,
                           @Value("${application.api.version:1.0}") String appVersion) {
        return new OpenAPI().info(new Info().title(appTitle).version(appVersion).description(appDescription));
    }
}