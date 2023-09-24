//package ar.edu.unq.cryptop2p.utils;
/*
import org.mapstruct.Context;
import org.springframework.context.annotation.Bean;
import org.springframework.context.aot.AbstractAotProcessor;
import org.springframework.context.aot.ContextAotProcessor;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import  org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.http.HttpClient;

@EnableWebSecurity
@EnableMethodSecurity (prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**",
            // -- Console H2
            "/h2-console/**",
            // other public endpoints of your API may be appended to this array
            "/users/**",
            "/cryptocurrencies/**",
            "/quotes/**",
            "/intentions/**",
            "/operations/**",
            "/auth/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(new Customizer<CsrfConfigurer<HttpSecurity>>() {
                    @Override
                    public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {

                    }
                })
                //.authorizeHttpRequests()
                .authorizeHttpRequests(
                        new AuthorizeHttpRequestsConfigurer<HttpSecurity>()



  //              .antMatchers(HttpMethod.DELETE)
  //              .hasRole("ADMIN")

                .requestMatchers(AUTH_WHITELIST)
                .anonymous()
                .anyRequest()
                .authenticated()

//                .and()
//                .httpBasic()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http.headers().frameOptions().disable();
        return http.build();
    }
}
*/
