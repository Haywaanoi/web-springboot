package com.example.demohotel.service;

import com.example.demohotel.model.Loaiphong;
import com.example.demohotel.model.Phong;

import java.util.List;
import java.util.Optional;

public interface PhongService {
    List<Phong> findAll();

    void deletebyId(Long id);

    Phong findbyId(Long id);

    Phong save(Phong phong);

    List<Phong> findByName(String name);

    List<Phong> findByLoaiPhongId(Loaiphong id);



}
