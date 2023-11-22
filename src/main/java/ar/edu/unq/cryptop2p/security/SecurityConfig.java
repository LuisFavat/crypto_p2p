
package ar.edu.unq.cryptop2p.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

   /*
    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }
*/
    // @Autowired
    // private  JwtAuthenticationFilter   jwtAuthenticationFilter;

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    private static final String[] AUTH_WHITELIST = {
            "/doc/swagger-ui/**",
            "/v3/api-docs/**",
            "/h2-console/**",
            "/auth/**",
            "/api/crypto/**",
            "/api/option/**",
            "/api/transaction/**",
            "/api/user/**",
    };


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http
                .csrf()
                .ignoringRequestMatchers(antMatcher("/**"))
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                //.requestMatchers(AUTH_WHITELIST)
                .requestMatchers(antMatcher("/v3/api-docs/"))
                .permitAll()

                .requestMatchers(antMatcher("/v3/api-docs/**"))
                .permitAll()

                .requestMatchers(antMatcher("/swagger-ui.html"))
                .permitAll()

                .requestMatchers(antMatcher("/swagger-ui/**"))
                .permitAll()

                .requestMatchers(antMatcher("/auth/**"))
                .permitAll()

                .requestMatchers(antMatcher("/api/crypto/**"))
                .permitAll()

                .requestMatchers(antMatcher("/api/option/options"))
                .permitAll()

                .requestMatchers(toH2Console())
                .permitAll()
                .anyRequest()
                .authenticated();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();


    }
}