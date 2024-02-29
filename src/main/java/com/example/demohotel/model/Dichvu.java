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
@Table(name = "dichvu")
public class Dichvu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDichVu", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "TenDichVu")
    private String tenDichVu;

    @Lob
    @Column(name = "MoTaDichVu")
    private String moTaDichVu;

    @Column(name = "GiaDichVu", precision = 10, scale = 2)
    private BigDecimal giaDichVu;

    @OneToMany(mappedBy = "maDichVu")
    @ToString.Exclude
    private Set<Datphong> datphongs ;

}