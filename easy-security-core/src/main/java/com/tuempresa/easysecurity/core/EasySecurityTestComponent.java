package com.tuempresa.easysecurity.core;

import org.springframework.stereotype.Component;

import com.tuempresa.easysecurity.properties.EasySecurityProperties;

import jakarta.annotation.PostConstruct;

@Component
public class EasySecurityTestComponent {

    private final EasySecurityProperties easySecurityProperties;

    public EasySecurityTestComponent(EasySecurityProperties easySecurityProperties) {
        this.easySecurityProperties = easySecurityProperties;
    }

    @PostConstruct
    public void init() {
       // System.out.println("Easy Security Enabled: " + easySecurityProperties.isEnabled());
    }

}
