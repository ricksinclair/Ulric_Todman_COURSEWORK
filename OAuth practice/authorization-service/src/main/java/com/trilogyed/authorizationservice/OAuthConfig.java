package com.trilogyed.authorizationservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import java.util.concurrent.ExecutionException;

@Configuration
@EnableAuthorizationServer
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.inMemory()
                .withClient("html5")
                .authorizedGrantTypes("password")
                .scopes( "ROLE_LVL1", "ROLE_LVL2")
                .secret("$2a$10$efrPGlmZS1Kanh58.KmXmeAkhvO4mcZt3iNEEtA8iElw1LKB45dKu");

        clients.inMemory()
                .withClient("android")
                .authorizedGrantTypes("password")
                .scopes( "ROLE_ADMIN", "ROLE_LVL1", "ROLE_LVL2")
                .secret("$2a$10$HG5sO9SoJEFhIPrhxj9ub.UJjPy7LhCrF6jqjLUBiyABpuSWHjei2");
        clients.inMemory()
                .withClient("iphone")
                .authorizedGrantTypes("password")
                .scopes( "ROLE_ADMIN", "ROLE_LVL1", "ROLE_LVL2")
                .secret("$2a$10$vJupalQtEuJsVE48mZptu.xasdPKAOleCcT.4l9enfB2LsYu94jzi");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
        endpoints.authenticationManager(this.authenticationManager);
    }
}
