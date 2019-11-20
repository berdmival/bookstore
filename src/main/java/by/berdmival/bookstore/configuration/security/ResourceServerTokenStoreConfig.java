package by.berdmival.bookstore.configuration.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
public class ResourceServerTokenStoreConfig {
    @Value("${spring.security.oauth2.client.registration.okta.client-id}")
    String clientId;
    @Value("${spring.security.oauth2.client.registration.okta.client-secret}")
    String clientSecret;


    @Primary
    @Bean
    public ResourceServerTokenServices remoteTokenServices() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(
                "http://localhost:8081/oauth/check_token");
        tokenService.setClientId(clientId);
        tokenService.setClientSecret(clientSecret);
        return tokenService;
    }
}
