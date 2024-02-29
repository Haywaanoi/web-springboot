package com.example.demohotel.repository;

import com.example.demohotel.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    List<Admin> findByHoTenIgnoreCaseAllIgnoreCaseOrderByHoTenAsc(@Nullable String hoTen);

    Admin findByTenDangNhap(String tenDangNhap);

    boolean existsByTenDangNhap(String tenDangNhap);

}
