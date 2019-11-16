package by.berdmival.bookstore.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
public class ResourceServerTokenStoreConfig {

    @Primary
    @Bean
    public ResourceServerTokenServices remoteTokenServices() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(
                "http://localhost:8081/oauth/check_token");
        tokenService.setClientId("client");
        tokenService.setClientSecret("secret");
        return tokenService;
    }
}
