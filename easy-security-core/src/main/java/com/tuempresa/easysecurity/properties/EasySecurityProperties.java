package com.tuempresa.easysecurity.properties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "easysecurity")
public class EasySecurityProperties {

    public static final List<String> DEFAULT_PATHS_IGNORE = List.of(
        "/actuator/**",
        "/health",
        "/info",
        "/error",
        "/favicon.ico",
        "/v3/api-docs/**",
        "/swagger-ui/**"
    );

    private List<String> pathsIgnore = new ArrayList<>();
    private boolean appendDefaultPaths = false;

    public List<String> getPathsIgnore() {
        return pathsIgnore;
    }

    public void setPathsIgnore(List<String> pathsIgnore) {
        this.pathsIgnore = pathsIgnore;
    }

    public boolean isAppendDefaultPaths() {
        return appendDefaultPaths;
    }

    public void setAppendDefaultPaths(boolean appendDefaultPaths) {
        this.appendDefaultPaths = appendDefaultPaths;
    }
}
