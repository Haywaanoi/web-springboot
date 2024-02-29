package com.example.demohotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdminID", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "HoTen")
    private String hoTen;

    @Size(max = 50)
    @Column(name = "TenDangNhap", length = 50)
    private String tenDangNhap;

    @Size(max = 255)
    @Column(name = "MatKhau")
    private String matKhau;

    @Size(max = 10)
    @Column(name = "Role", length = 10)
    private String role;

    @PrePersist
    public void setPassword() {
        // Mã hóa mật khẩu sử dụng BCryptPasswordEncoder
        BCryptPasswordEncoder password = new BCryptPasswordEncoder();
        this.matKhau = password.encode(matKhau);
    }
    @PreUpdate
    public void updatePassword() {
        // Mã hóa mật khẩu sử dụng BCryptPasswordEncoder
        BCryptPasswordEncoder password = new BCryptPasswordEncoder();
        this.matKhau = password.encode(matKhau);
    }
}