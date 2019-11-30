package com.squaddois.centralerros.security;

import com.auth0.Auth0;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("auth0.properties")
public class Auth0Configuration {
    @Value(value = "auth0.clientSecret")
    private String clientSecret;

    @Value(value = "auth0.clientId")
    private String clientId;

    @Value(value = "auth0.domain")
    private String domain;

    @Bean
    public Auth0 getAuth0() {
        return new Auth0(clientId, clientSecret, domain);
    }

}
