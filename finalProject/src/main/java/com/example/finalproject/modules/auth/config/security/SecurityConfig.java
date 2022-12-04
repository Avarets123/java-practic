package com.example.finalproject.modules.auth.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService customUserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();

        httpSecurity
                .formLogin()
                .loginPage("/signIn")
                .failureUrl("/signIn?error")
                .defaultSuccessUrl("/films")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll();

        httpSecurity.authorizeHttpRequests().antMatchers("/signUp/**").permitAll();
        httpSecurity.authorizeHttpRequests().antMatchers("/films").permitAll();
        httpSecurity.authorizeHttpRequests().antMatchers("/films/**").permitAll();
        httpSecurity.authorizeHttpRequests().antMatchers("profile").authenticated();
        httpSecurity.authorizeHttpRequests().antMatchers("/users/**").hasAuthority("ADMIN");
        return httpSecurity.build();
    }

    @Autowired
    public void bindUserDetailService(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }


}
