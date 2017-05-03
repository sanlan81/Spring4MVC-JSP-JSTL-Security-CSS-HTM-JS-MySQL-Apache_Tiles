package com.mysuperscore.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired
   // @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    ///2
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
      // auth.userDetailsService(userDetailsService);
        //  auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
       // auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
               // .antMatchers("/bill*").access("hasRole('USER')")
                .antMatchers("/admin*").access("hasRole('ADMIN')")
                //.antMatchers("/db*").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin()
                .and().rememberMe().rememberMeParameter("remember-me").tokenValiditySeconds(86400)
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");

        http.formLogin()
                .loginPage("/login")
                //.loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll();

        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").access("hasRole('ADMIN')")
                .antMatchers("/create").access("hasRole('ADMIN')")
                .antMatchers("/resources*").permitAll()
                .anyRequest().permitAll()
                .and();

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);
    }

      ///3
  /*  @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/admin*//**").access("hasRole('ADMIN')")
                .antMatchers("/db*//**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin().loginPage("/login")
                .usernameParameter("ssoId").passwordParameter("password")
                .and().rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400)
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
        return tokenRepositoryImpl;
    }*/


    ///4
    /*  @Autowired
   *//* @Qualifier("customUserDetailsService")*//*
    UserDetailsService userDetailsService;
*/
 /*   @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/admin*").access("hasRole('ADMIN')")
     .antMatchers("/db*").access("hasRole('ADMIN') and hasRole('DBA')")
     .and().formLogin().loginPage("/login")
     //.passwordParameter("j_password")
     .and().rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400)
     .and().csrf()
     .and().exceptionHandling().accessDeniedPage("/Access_Denied");

     }

     @Bean
     public PersistentTokenRepository persistentTokenRepository() {
     JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
     tokenRepositoryImpl.setDataSource(dataSource);
     return tokenRepositoryImpl;
     }*/
}