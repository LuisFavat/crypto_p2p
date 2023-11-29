package ar.edu.unq.cryptop2p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class CryptoP2pApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoP2pApplication.class, args);
	}

}
