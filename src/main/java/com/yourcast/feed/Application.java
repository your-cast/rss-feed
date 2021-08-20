package com.yourcast.feed;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("1.0.0") String appVersion) {
        Server localServer = new Server().url("http://localhost:8080").description("Local");
        ArrayList<Server> servers = new ArrayList<Server>();
        servers.add(localServer);

        return new OpenAPI().info(
            new Info().title("RSS feed API")
                .version(appVersion)
                .description("Service for generate RSS feed")
                .license(new License().name("Licensed by Your-Cast").url("https://your-cast.com/"))
        ).servers(servers);
    }
}
