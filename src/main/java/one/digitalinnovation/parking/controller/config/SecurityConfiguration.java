package one.digitalinnovation.parking.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    //Configura autorização
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/csrf").permitAll()
                .antMatchers("/*.js").permitAll()
                .antMatchers("/*.css").permitAll()
                .antMatchers("/*.ico").permitAll()
                .antMatchers("/*.png").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
