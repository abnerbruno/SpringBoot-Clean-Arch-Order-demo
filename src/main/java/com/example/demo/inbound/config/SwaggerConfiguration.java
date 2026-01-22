package com.example.demo.inbound.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    private static final String SWAGGER_TITLE = "Demo Order";

    private static final String SWAGGER_DESCRIPTION = "API PROCESS ORDER";

    private static final String SERVICE_VERSION = "1.0.0";

    private Server customServer(String url, String description) {
        Server server = new Server();
        server.setUrl(url);
        server.setDescription(description);
        return server;
    }

    private Info getInfo() {
        return new Info().title(SWAGGER_TITLE).description(SWAGGER_DESCRIPTION).version(SERVICE_VERSION);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openAPI = new OpenAPI();

        openAPI.addServersItem(customServer("http://localhost:8080", "Desenvolvimento local"));
        openAPI.info(getInfo());

        return openAPI;
    }

}