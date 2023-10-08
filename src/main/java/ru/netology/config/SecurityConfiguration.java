package ru.netology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;


@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder encoder() {
		//return new BCryptPasswordEncoder();
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return passwordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password(encoder().encode("Welcome@1"))
			.roles("READ", "WRITE", "DELETE")
			.and()
			.withUser("Garrik")
			.password(encoder().encode("Welcome@2"))
			.roles("READ", "WRITE")
			.and()
			.withUser("Ivan")
			.password(encoder().encode("Welcome@3"))
			.roles("READ")
			.and()
			.withUser("Vasiliy")
			.password(encoder().encode("Welcome@4"))
			.roles("WRITE")
			.and()
			.withUser("Дмитрий")
			.password(encoder().encode("Welcome@5"))
			.roles("READ");
	}
}


