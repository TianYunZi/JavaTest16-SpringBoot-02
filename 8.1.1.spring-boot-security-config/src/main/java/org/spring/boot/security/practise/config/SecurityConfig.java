package org.spring.boot.security.practise.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService) throws Exception {
//        auth.inMemoryAuthentication().withUser("user01")
//                .password("abc123##").roles("USER");
        auth.userDetailsService(userDetailsService);
    }

//    @Override
//    @Bean("userDetailsService")
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        //内存中存放用互信息
//        manager.createUser(User.withUsername("user").password("abc123##").roles("USER").build());
//        manager.createUser(User.withUsername("admin").password("abc123##").roles("ADMIN", "USER").build());
//        return manager;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/blogs/**").hasRole("USER")
                .antMatchers("/api/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login")
                .failureUrl("/login-error")
                .and()
                .exceptionHandling().accessDeniedPage("/401");
        http.logout().logoutSuccessUrl("/");
    }
}
