package com.example.demohotel.repository;

import com.example.demohotel.model.Loaiphong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoaiPhongRepository extends JpaRepository<Loaiphong,Long> {
    List<Loaiphong> findByTenLoaiPhong(String name);
}
