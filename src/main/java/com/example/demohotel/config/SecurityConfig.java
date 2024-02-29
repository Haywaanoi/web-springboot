package com.example.demohotel.config;

import com.example.demohotel.config.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {


    @Bean
    public CustomUserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,AuthenticationSuccessHandler customSuccessHandler) throws Exception {
        http.authorizeHttpRequests(configure->
                configure
                        .requestMatchers("/css/**","/fonts/**","/img/**","/js/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**","/booking/*").hasAnyRole("ADMIN","USER")
                        .requestMatchers("/*","/register/*","/chitietphong/**").permitAll()
                        .anyRequest().authenticated()
        )
                .formLogin(form->
                        form
                                .loginPage("/showlogin")
                                .loginProcessingUrl("/process")
                                .successHandler(customSuccessHandler)
                                .permitAll()
                )
                .logout(logout->logout
                        .logoutSuccessUrl("/showlogin?logout")
                        .permitAll()
                )
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied")
        );
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            UserDetails userDetails;
//
//            Admin admin = adminRepository.findByTenDangNhap(username);
//            Khachhang khachhang = userRepository.findByTenDangNhap(username);
//
//            if (admin != null) {
//                userDetails = User.withUsername(admin.getTenDangNhap())
//                        .password(passwordEncoder().encode(admin.getMatKhau()))
//                        .roles(admin.getRole())
//                        .build();
//            } else if (khachhang != null) {
//                userDetails = User.withUsername(khachhang.getTenDangNhap())
//                        .password(passwordEncoder().encode(khachhang.getMatKhau()))
//                        .roles(khachhang.getRole())
//                        .build();
//            } else {
//                throw new UsernameNotFoundException("User not found with username: " + username);
//            }
//            return userDetails;
//        };
//    }

}
