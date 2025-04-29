package com.tuempresa.easysecurity.core;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnMissingBean(EasySecurityCoreAutoConfiguration.class)
@Import(EasySecuritySecurityConfig.class)
public class EasySecurityCoreAutoConfiguration {
    public EasySecurityCoreAutoConfiguration() {
        System.out.println("[easy-security-core] Autoconfig initialized");
    }
}