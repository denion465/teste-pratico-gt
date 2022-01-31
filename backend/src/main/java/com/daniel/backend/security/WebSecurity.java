package com.daniel.backend.security;

import com.daniel.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter {
  private final UserService userService;
  private final BCryptPasswordEncoder bcryptPasswordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
      .permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .addFilter(getAuthenticationFilter())
      .addFilter(new AuthenticationFilter(authenticationManager()))
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(bcryptPasswordEncoder);
  }

  public AuthenticationFilter getAuthenticationFilter() throws Exception {
    final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
    filter.setFilterProcessesUrl(SecurityConstants.SIGN_IN_URL);

    return filter;
  }
}
