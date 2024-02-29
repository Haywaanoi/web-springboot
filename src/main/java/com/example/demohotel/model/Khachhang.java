package com.example.demohotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "khachhang")
public class Khachhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhachHang", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "HoTen")
    private String hoTen;

    @Size(max = 20)
    @Column(name = "SoDienThoai", length = 20)
    private String soDienThoai;

    @Size(max = 255)
    @Column(name = "Email")
    private String email;


    @Size(max = 50)
    @Column(name = "TenDangNhap", length = 50)
    private String tenDangNhap;

    @Size(max = 255)
    @Column(name = "MatKhau")
    private String matKhau;

    @OneToMany(mappedBy = "maKhachHang")
    @ToString.Exclude
    private Set<Datphong> datphongs ;

    @Size(max = 20)
    @Column(name = "Role", length = 20)
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