package com.itacademy.dicesgame;

import com.itacademy.dicesgame.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class DicesgameApplication {

	 public static void main(String[] args) {
		SpringApplication.run(DicesgameApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	 	@Override
		protected void configure(HttpSecurity http) throws Exception{
	 		http
					.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(),
							UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/user").permitAll()

					.antMatchers(HttpMethod.GET, "/players", "/players/", "/players/ranking", "/players/**", "/players/ranking/loser", "/players/ranking/winner").authenticated()
					.antMatchers(HttpMethod.POST, "/players").authenticated()
					.antMatchers(HttpMethod.PUT, "/players/**").authenticated()

					.anyRequest().permitAll();
		}
	}

}
