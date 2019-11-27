package com.squaddois.centralerros.config;

import com.squaddois.centralerros.dto.UserCustomDTO;
import com.squaddois.centralerros.entity.User;
import com.squaddois.centralerros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManagerBean();
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository, Encoder encoder)
            throws Exception {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setEmail("admin@admin.com");
            user.setPassword(encoder.passwordEncoder().encode("admin"));
            user.setName("Admin");
            user.setLastName("Teste");
            user.setToken("jhfkahfkh");
            userRepository.save(user);
        }

        builder.userDetailsService(email -> new UserCustomDTO(userRepository.findByEmail(email)))
                .passwordEncoder(encoder.passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }
}