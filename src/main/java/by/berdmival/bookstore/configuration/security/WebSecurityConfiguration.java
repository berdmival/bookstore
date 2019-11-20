package by.berdmival.bookstore.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/books").anonymous()
                .antMatchers("/books/**").authenticated()
                .antMatchers("/authors/**").authenticated()
                .antMatchers("/genres/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .oauth2Login()
                .and()
                .logout();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/resources/**",
                        "/static/**",
                        "/css/**", "/js/**", "/images/**",
                        "/webjars/**",
                        "/h2-console/**");
    }
}
