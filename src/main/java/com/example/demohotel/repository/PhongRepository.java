package com.example.demohotel.repository;

import com.example.demohotel.model.Loaiphong;
import com.example.demohotel.model.Phong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface PhongRepository extends JpaRepository<Phong, Long> {
    @Query("SELECT DISTINCT p FROM Phong p WHERE p NOT IN (" +
            "SELECT dp.maPhong FROM Datphong dp " +
            "WHERE (CAST(:checkInDate AS DATE) BETWEEN dp.ngayNhanPhong AND dp.ngayTraPhong) " +
            "OR (CAST(:checkOutDate AS DATE) BETWEEN dp.ngayNhanPhong AND dp.ngayTraPhong)) " +
            "GROUP BY p.loaiPhongID.tenLoaiPhong")
    List<Phong> findAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate);

    List<Phong> findByTenPhong(String name);

    List<Phong> findByLoaiPhongID(Loaiphong id);

}
