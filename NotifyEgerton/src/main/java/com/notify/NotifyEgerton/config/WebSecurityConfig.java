package com.notify.NotifyEgerton.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        AuthenticationManager authenticationManager;

        @Autowired
        private DataSource dataSource;

        @Autowired
        CustomSuccessHandler customSuccessHandler;

        @Autowired
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.jdbcAuthentication().dataSource(dataSource)
                                .usersByUsernameQuery(
                                                "select username as principal, password as credentials, true from user where username = ?")
                                .authoritiesByUsernameQuery(
                                                "select username as pricipal, role as role from user_roles where username = ? ")
                                .passwordEncoder(passwordencoder()).rolePrefix("ROLE_");
        }

        @Bean
        protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http
                                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                                                .antMatchers("/", "/Help", "/restPassword", "/index", "/registration",
                                                                "/style/**",
                                                                "/javascript/**", "/images/**", "/fonts/**",
                                                                "/webjars/**")
                                                .permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(formLogin -> formLogin
                                                .loginPage("/login")
                                                .usernameParameter("username")
                                                .passwordParameter("password").permitAll()
                                                .successHandler(customSuccessHandler))
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/?logout"))
                                .exceptionHandling(handling -> handling
                                                .accessDeniedPage("/403"))
                                .csrf(csrf -> csrf
                                                .disable());

                return http.build();

        }

        @Bean(name = "passordEncoder")
        public PasswordEncoder passwordencoder() {
                return new BCryptPasswordEncoder();
        }

}
