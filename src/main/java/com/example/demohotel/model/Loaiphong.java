package com.example.demohotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "loaiphong")
public class Loaiphong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoaiPhongID", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "TenLoaiPhong")
    private String tenLoaiPhong;

    @Lob
    @Column(name = "MoTaLoaiPhong")
    private String moTaLoaiPhong;

    @Column(name = "GiaLoaiPhong", precision = 10, scale = 2)
    private BigDecimal giaLoaiPhong;

    @Size(max = 255)
    @Column(name = "DuongDanHinhAnh")
    private String duongDanHinhAnh;

    @OneToMany(mappedBy = "loaiPhongID")
    @ToString.Exclude
    private Set<Phong> phongs ;

}