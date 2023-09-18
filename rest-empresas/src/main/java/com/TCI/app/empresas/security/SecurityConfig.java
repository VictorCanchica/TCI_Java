package com.TCI.app.empresas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	
	private static final String[] AUTH_USER_LVL = {
            "/empresas/listar",
            "empresas/listar/*",
            "/empresas/listar/ultimos/*"
    };
	private static final String[] AUTH_ADMIN_LVL = {
			"/empresas/registrar",
			"/empresas/editar",
			"empresas/eliminar"
    };
	
    @Bean
    static PasswordEncoder passwordEncoder(){
	    return new BCryptPasswordEncoder();
	
	}
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	
    	http
    	.cors(AbstractHttpConfigurer::disable)
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .formLogin(AbstractHttpConfigurer::disable)
        .securityMatcher("/**")
        .authorizeHttpRequests(registry -> registry
        	
        		.requestMatchers(AUTH_USER_LVL).hasAnyRole("USER", "ADMIN")
        		.requestMatchers(AUTH_ADMIN_LVL).hasAnyRole("ADMIN")
        		.anyRequest().authenticated())
        		.httpBasic(Customizer.withDefaults());;     		

    			
    			return http.build();
	    		
	    		
	    	}

    @Bean
    UserDetailsService userDetailsService(){

    	UserDetails usuario = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(usuario,admin);
    }
    
}
