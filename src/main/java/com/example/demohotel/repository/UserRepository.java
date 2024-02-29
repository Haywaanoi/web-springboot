package com.example.demohotel.repository;

import com.example.demohotel.model.Dichvu;
import com.example.demohotel.model.Khachhang;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Khachhang,Long> {

    Khachhang findByTenDangNhap(String tenDangNhap);

    boolean existsByTenDangNhap(String tenDangNhap);


}
