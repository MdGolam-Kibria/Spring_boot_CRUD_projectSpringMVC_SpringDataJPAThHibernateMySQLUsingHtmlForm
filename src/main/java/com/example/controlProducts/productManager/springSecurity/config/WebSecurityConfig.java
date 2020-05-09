package com.example.controlProducts.productManager.springSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //for this spring security document source = https://www.codejava.net/frameworks/spring-boot/form-authentication-with-jdbc-and-mysql
    //another high level sp...security = https://youtu.be/_-CqWDqWaNk?list=PLR2yPNIFMlL9UUF6-syrVrNaRwHVJofZE.
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/").permitAll()//here I have given permission to everyone here on the home page but this line don't need now that's why comment this line
                .antMatchers("/edit/*", "/delete/*").hasRole("ADMIN")//this url's only accessible for admin role
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .loginPage("/login")//this url must match with controller which controller return the login page and her url has similarity with this
                .usernameParameter("email")//this "email" must match with the input level name  in login html
                .passwordParameter("bcriptPassword")//this "bcriptPassword" must match with the password input level in login html
                .loginProcessingUrl("/doLogIn")//This is login in page html from action url like "th:action="/doLogIn"where the login process will continue.
                .defaultSuccessUrl("/doLogIn")//after successfully login what url access i have said that
                .failureUrl("/login_error")//this url handle with AllViewController.java class 2 number line and create a login-error.html page
//                .successForwardUrl("/")//this url must match with controller which controller return the login page and her url has similarity with this
//                .failureForwardUrl("/login_error")//if login is unsuccessfully //this comment two line is a way another way below
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        if (authentication.isAuthenticated()) {//if user have isAuthenticated
                            System.out.println("The user Name is = " + authentication.getName());
                            response.sendRedirect("/");
                        }
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                       response.sendRedirect("/login_error");//this parameter must be add a html file over the AllViewController.java class 2 number line
                    }
                })
                .and()
                .logout()
                    .permitAll()
                .logoutUrl("/doLogOut")//This logout "/doLogOut" must match with html button submit form url
                .logoutSuccessUrl("/againLogIn")//this parameter must be add a html file over the AllViewController.java class 3 number line
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        System.out.println("Good Bye = "+authentication.getAuthorities());

                        response.sendRedirect("/againLogIn");//this parameter must be add a html file over the AllViewController.java class 3 number line
                    }
                })
                .and()
                .exceptionHandling().accessDeniedPage("/403");//any Exception here then show this "/403" controller url and control it from AllViewController.java class 1st line.
    }

    @Override//best way for Ignore spring security for a fixed url
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/home");
        web.ignoring().antMatchers("/getAllProductByIdNameBrandMadeinPrice/**");//this is the ignoring way for searching a
        // method
        //Below
        // Spring Security should completely ignore URLs ending with .html so just use the controller method access URL like here "/" this is for MVC WEB page
       // web.ignoring().antMatchers("/");//this line comment reason is i don't need this but this method is true.
     }
}
