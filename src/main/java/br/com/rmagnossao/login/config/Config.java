package br.com.rmagnossao.login.config;

import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.datasource.username}")
	String user;
	
	@Value("${spring.datasource.password}")
	String password;
	
	@Bean
	public DBI setDbi () {
		return  new DBI(url, user, password); 

		
	}

}
