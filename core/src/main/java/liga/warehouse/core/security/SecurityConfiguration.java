package liga.warehouse.core.security;

import liga.warehouse.dto.enumeration.Authority;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfiguration(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/**", "/roles/**").hasAuthority(Authority.OWNER.name())
                .antMatchers(HttpMethod.GET).hasAnyAuthority(Authority.ADMIN.name(), Authority.OWNER.name(), Authority.USER.name())
                .antMatchers(HttpMethod.POST).hasAnyAuthority(Authority.ADMIN.name(), Authority.OWNER.name())
                .antMatchers(HttpMethod.PATCH).hasAnyAuthority(Authority.ADMIN.name(), Authority.OWNER.name())
                .antMatchers(HttpMethod.PUT).hasAnyAuthority(Authority.ADMIN.name(), Authority.OWNER.name())
                .antMatchers(HttpMethod.DELETE).hasAnyAuthority(Authority.ADMIN.name(), Authority.OWNER.name())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();
    }
}
