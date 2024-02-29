package com.example.demohotel.service;

import com.example.demohotel.model.Khachhang;
import com.example.demohotel.model.Phong;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean existsByTenDangNhap(String tenDangNhap);

    List<Khachhang> findAll();

     Khachhang findByName(String hoTen);

    void deletebyId(Long id);

    Khachhang findbyId(Long id);

    Khachhang save(Khachhang khachhang);
}
