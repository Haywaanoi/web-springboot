package com.example.demohotel.service;

import com.example.demohotel.model.Loaiphong;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface LoaiPhongService {
    List<Loaiphong> findByTenLoaiPhong(String name);

    List<Loaiphong> findAll();

    <S extends Loaiphong> S save(S entity);

   Loaiphong findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Loaiphong entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Loaiphong> entities);

    void deleteAll();

    String saveFile(MultipartFile file) throws  IOException;
}
