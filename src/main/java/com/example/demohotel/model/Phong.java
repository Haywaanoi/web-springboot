package com.example.demohotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "phong")
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhong", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "TenPhong")
    private String tenPhong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LoaiPhongID")
    @ToString.Exclude
    private Loaiphong loaiPhongID;

    @OneToMany(mappedBy = "maPhong")
    @ToString.Exclude
    private List<Datphong> datphongs ;


}