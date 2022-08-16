package pl.paulkapela.colorchat.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableCaching
public class Config {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("^(?!/(error).*$).*$"))
                .build()
                .securitySchemes(Collections.singletonList(createSecuritySchema()))
                .securityContexts(Collections.singletonList(createSecurityContext()));
    }

    private SecurityContext createSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(createSecurityRef())
                .operationSelector(operationContext -> true)
                .build();
    }

    private List<SecurityReference> createSecurityRef() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");

        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        return Collections.singletonList(new SecurityReference("apiKey", authorizationScopes));
    }

    private SecurityScheme createSecuritySchema() {
        return new ApiKey("apiKey", HttpHeaders.AUTHORIZATION, "header");
    }
}
