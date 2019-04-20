package com.github.DominasPL.tennisapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource) // z czym ma się jdbc łączyć, połącznie z bazą
                .passwordEncoder(passwordEncoder()) //szyfrowanie hasła
                .usersByUsernameQuery("SELECT username, password, true FROM users WHERE username = ?") // pobieranie pól z bazy danych które wykorzystywane są w procesie logowania
                .authoritiesByUsernameQuery("SELECT username, 'ROLE_USER' FROM users WHERE username = ?"); // Rola uzytkownika
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //tak jak w bolku try catch od najbardziej szczegółowych do najmniej
                .antMatchers("/register").anonymous() // dostep dla niezalogowanych
                .antMatchers("/login").anonymous() // dostep dla niezalogowanych
                .antMatchers("/ranking").permitAll() // dostep dla niezalogowanych
                .antMatchers("/").permitAll() // dostep dla wszystkich
                .antMatchers("/user", "/user/**").hasRole("USER") // tylko dla userow
                .antMatchers("/admin", "/admin/**").hasRole("ADMIN") // tylko dla adminow
                .antMatchers("/media/**").permitAll()//dostep do folderu media dla wszystkich
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/") // domyślna strona po zalogowaniu
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/") // strona po wylogowaniu
                .and()
            .csrf()
                .disable()
            .rememberMe()
                .key("TajnyKluczremeberMe") // klucz uzyty do zaszyfrowania hasła użytkownika(nie wymagamy logowania, stworzenie ciastka zaszyfrowanego z uzyciem tego klucza)
                .rememberMeParameter("remember-me")// mamy formularz logowania i checkbox
                .tokenValiditySeconds(7*24*60*60); // czas życia ciasteczka

    }

}
