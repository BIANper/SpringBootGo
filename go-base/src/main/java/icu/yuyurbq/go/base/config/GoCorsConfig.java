package icu.yuyurbq.go.base.config;

import icu.yuyurbq.go.base.config.autoconfigure.GoCorsProperties;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

public class GoCorsConfig {

    private GoCorsProperties corsProperties;

    public void setCorsProperties(GoCorsProperties corsProperties) {
        this.corsProperties = corsProperties;
    }

    public CorsWebFilter FilterConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader(corsProperties.getAllowedHeader());
        corsConfiguration.addAllowedMethod(corsProperties.getAllowedMethod());
        corsConfiguration.addAllowedOrigin(corsProperties.getAllowedOrigin());
        corsConfiguration.setAllowCredentials(corsProperties.isAllowCredentials());

        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration(corsProperties.getApplyPath(),corsConfiguration);
        return new CorsWebFilter(configurationSource);
    }

}
