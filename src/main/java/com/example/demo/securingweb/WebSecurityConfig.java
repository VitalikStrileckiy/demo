package com.example.demo.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/", "/Main","/SignUp","/resources/**",  "../../static/Main.css").permitAll()
//                        .anyRequest().authenticated()
//                );
//        http.authorizeHttpRequests().requestMatchers("/login*", "/", "/Main", "/SignUp", "/resources/**",
//                        "/resources/static/**", "/resources/templates/**", "/static/Login.css", "/templates/**",
//                        "../../static/Main.css", "/Login.css" ).permitAll().and()
//                .formLogin((form) -> form
//                        .loginPage("/Login")
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll());

        http.authorizeHttpRequests().anyRequest().permitAll();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("biataru@gmail.com")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}