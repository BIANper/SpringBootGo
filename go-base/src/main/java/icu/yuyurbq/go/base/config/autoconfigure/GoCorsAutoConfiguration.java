package icu.yuyurbq.go.base.config.autoconfigure;

import icu.yuyurbq.go.base.config.GoCorsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({GoCorsConfig.class})
@EnableConfigurationProperties({GoCorsProperties.class})
@ConditionalOnProperty(prefix = "go.cors", name = "enabled", havingValue = "true")
public class GoCorsAutoConfiguration {

    @Autowired
    GoCorsProperties corsProperties;

    @Bean
    @ConditionalOnMissingBean(GoCorsConfig.class)
    public GoCorsConfig goCorsConfig() {
        GoCorsConfig corsConfig = new GoCorsConfig();
        corsConfig.setCorsProperties(corsProperties);
        return corsConfig;
    }
}
