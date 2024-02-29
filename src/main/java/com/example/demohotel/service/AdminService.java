package com.example.demohotel.service;

import com.example.demohotel.model.Admin;

import java.util.List;

public interface AdminService {
    boolean existsByTenDangNhap(String tenDangNhap);

    List<Admin> findAll();

    <S extends Admin> S save(S entity);

    Admin findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Admin entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Admin> entities);

    void deleteAll();



}
