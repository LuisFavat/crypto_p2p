package ar.edu.unq.cryptop2p.utils;

import ar.edu.unq.cryptop2p.webservice.UserCryptoController;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger.schema.OpenApiSchemaPropertyBuilder;
import java.util.Collections;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket( DocumentationType.SWAGGER_2)
                .select()

                .apis(RequestHandlerSelectors.basePackage("ar.edu.unq.cryptop2p.webservice"))
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                ;
    }




    @Contract(" -> new")
    private @NotNull ApiInfo getApiInfo() {
        return new ApiInfo(
                "Cryptop2p Grupo H",
                "Proyecto: Cryptop2p Grupo H" +
                        "Universidad: Universidad Nacional de Quilmes - UNQ" +
                        "Materia" + "Dapps (Desarrollo de aplicaciones)" +
                        "Integrantes: " +
                        "Alejandro Fariña" +
                        "Luis Favatier",
                "1.0",
                "Sprints de las entregas: " +
                        "https://greyfoxdevelop.atlassian.net/jira/software/projects/CRYPTO/boards/7/backlog",
                new Contact("Cryptop2p Grupo H", "https://github.com/LuisFavat/crypto_p2p", "algoritmosale@gmail.com"),
                "LICENSE MIT",
                "LICENSE MIT URL",
                Collections.emptyList()
        );
    }
}

