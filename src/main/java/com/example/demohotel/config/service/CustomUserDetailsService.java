package com.example.demohotel.config.service;

import com.example.demohotel.model.Admin;
import com.example.demohotel.model.Khachhang;
import com.example.demohotel.repository.AdminRepository;
import com.example.demohotel.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByTenDangNhap(username);
        Khachhang khachhang = userRepository.findByTenDangNhap(username);

        if (admin != null) {
            return User.withUsername(admin.getTenDangNhap())
                    .password(admin.getMatKhau())
                    .roles(admin.getRole())
                    .build();
        } else if (khachhang != null) {
            return User
                    .withUsername(khachhang.getTenDangNhap())
                    .password(khachhang.getMatKhau())
                    .roles(khachhang.getRole())
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
