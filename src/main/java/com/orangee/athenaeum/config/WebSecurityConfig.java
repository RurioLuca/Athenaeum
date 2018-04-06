package com.orangee.athenaeum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


/**
 * Created by Luca on 02/03/2017.
 */
@Configuration
//@EnableWebSecurity
@EnableAutoConfiguration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;

    /*
    * configure (HttpSecurity) consente la configurazione della sicurezza basata sul Web a livello di risorsa,
    * in base a una corrispondenza di selezione, ad esempio L'esempio seguente limita gli URL
    * che iniziano con / admin / per gli utenti con ruolo ADMIN e dichiara che qualsiasi altro URL
    * deve essere autenticato con successo.
    */


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
                .antMatchers("/", "/register/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/loginfailed")
                .defaultSuccessUrl("/welcome", false)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");

    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery(
                        "SELECT matricola,password,1 from utente where matricola=?")
                .authoritiesByUsernameQuery("SELECT matricola ,'ROLE_USER' from utente where matricola=?")
                .dataSource(dataSource);
    }

    /*
    * configure (WebSecurity) viene utilizzato per le impostazioni di configurazione che
    * influiscono sulla sicurezza globale (ignorare le risorse, impostare la modalità di debug,
    * rifiutare le richieste implementando una definizione di firewall personalizzata).
    * Ad esempio, il metodo seguente causerebbe qualsiasi richiesta che inizia con / resources /
    * per essere ignorata ai fini dell'autenticazione.
    */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**");

    }
}
