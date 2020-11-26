package icu.yuyurbq.go.base.config.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "go.cors")
public class GoCorsProperties {
    private String allowedHeader = "*";
    private String allowedMethod = "*";
    private String allowedOrigin = "*";
    private boolean allowCredentials = true;
    private String applyPath = "/**";


    public String getAllowedHeader() {
        return allowedHeader;
    }

    public void setAllowedHeader(String allowedHeader) {
        this.allowedHeader = allowedHeader;
    }

    public String getAllowedMethod() {
        return allowedMethod;
    }

    public void setAllowedMethod(String allowedMethod) {
        this.allowedMethod = allowedMethod;
    }

    public String getAllowedOrigin() {
        return allowedOrigin;
    }

    public void setAllowedOrigin(String allowedOrigin) {
        this.allowedOrigin = allowedOrigin;
    }

    public boolean isAllowCredentials() {
        return allowCredentials;
    }

    public void setAllowCredentials(boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    public String getApplyPath() {
        return applyPath;
    }

    public void setApplyPath(String applyPath) {
        this.applyPath = applyPath;
    }
}
