package com.example.demohotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "hoadon")
public class Hoadon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHoaDon", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDatPhong")
    @ToString.Exclude
    private Datphong maDatPhong;

    @Column(name = "TongTien", precision = 10, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "NgayXuatHoaDon")
    private Date ngayXuatHoaDon;

}