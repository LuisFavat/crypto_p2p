package ar.edu.unq.cryptop2p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication//(exclude = {UserDetailsServiceAutoConfiguration.class})
//@Configuration
public class CryptoP2pApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoP2pApplication.class, args);
	}

}
