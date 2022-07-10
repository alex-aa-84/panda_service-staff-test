package wwf.org.staff;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // @formatter:off
        http.cors().and().authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt()
                .and();
        // @formatter:on
    }
}