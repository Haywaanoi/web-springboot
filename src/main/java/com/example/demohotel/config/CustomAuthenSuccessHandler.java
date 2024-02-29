package com.example.demohotel.config;

import com.example.demohotel.config.service.CustomUserDetailsService;
import com.example.demohotel.service.AdminService;
import com.example.demohotel.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Collection;
@AllArgsConstructor
@Component
public class CustomAuthenSuccessHandler implements AuthenticationSuccessHandler {
    private AdminService adminService;
    private UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        if (AuthorityUtils.authorityListToSet(authorities).contains("ADMIN")) {
//            response.sendRedirect("/admin/home");
//        } else if (AuthorityUtils.authorityListToSet(authorities).contains("USER")) {
//            response.sendRedirect("/user/home");
//        } else {
//            throw new IllegalStateException("Unexpected role found: " + authorities);
//        }
        String username = authentication.getName();
        // Check if the user is an admin
        if (adminService.existsByTenDangNhap(username)) {
            response.sendRedirect("/admin/home");
        }
        // Check if the user is a regular user
        else if (userService.existsByTenDangNhap(username)) {
            response.sendRedirect("/");
        } else {
            throw new IllegalStateException("Unexpected user found: " + username);
        }
    }

}
