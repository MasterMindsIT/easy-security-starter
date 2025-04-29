package com.tuempresa.easysecurity.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import com.tuempresa.easysecurity.properties.EasySecurityProperties;



@Configuration
@EnableConfigurationProperties(EasySecurityProperties.class)
public class EasySecuritySecurityConfig  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, EasySecurityProperties props) throws Exception {
        List<String> pathsToIgnore = new ArrayList<>();

        if (props.isAppendDefaultPaths()) {
            pathsToIgnore.addAll(EasySecurityProperties.DEFAULT_PATHS_IGNORE);
        }

        pathsToIgnore.addAll(props.getPathsIgnore());

        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(pathsToIgnore.toArray(new String[0])).permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
}

}