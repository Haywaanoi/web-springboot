package com.example.demohotel.service;

import com.example.demohotel.model.Hoadon;

import java.util.List;

public interface HoaDonService {
    List<Hoadon> findAll();

    <S extends Hoadon> S save(S entity);

    Hoadon findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Hoadon entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Hoadon> entities);

    void deleteAll();
}
