package com.example.demohotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "datphong")
public class Datphong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDatPhong", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhachHang")
    @ToString.Exclude
    private Khachhang maKhachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhong")
    @ToString.Exclude
    private Phong maPhong;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgayNhanPhong")
    private Date ngayNhanPhong;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NgayTraPhong")
    private Date ngayTraPhong;

    @Column(name = "SoKhach")
    private Integer soKhach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDichVu")
    @ToString.Exclude
    private Dichvu maDichVu;

    @NotNull
    @Column(name = "ngay_tao", nullable = false)
    private LocalDate ngayTao;

    @OneToMany(mappedBy = "maDatPhong")
    @ToString.Exclude
    private List<Hoadon> hoadons ;



}