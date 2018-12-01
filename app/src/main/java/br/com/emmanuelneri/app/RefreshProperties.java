package br.com.emmanuelneri.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@RefreshScope
public class RefreshProperties {

    @Value("${cliente.name}")
    private String clientName;

    @Value("${hello.api.active}")
    private boolean helloApiActive;

    public String getClientName() {
        return clientName;
    }

    public boolean isHelloApiActive() {
        return helloApiActive;
    }
}
