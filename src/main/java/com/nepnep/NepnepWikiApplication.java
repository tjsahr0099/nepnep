package com.nepnep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class NepnepWikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NepnepWikiApplication.class, args);
	}

}
