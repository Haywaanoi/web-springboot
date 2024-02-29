package com.example.demohotel.service;

import com.example.demohotel.model.Datphong;

import java.util.List;

public interface DatPhongService {
    List<Datphong> findAll();


    <S extends Datphong> S save(S entity);

    Datphong findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Datphong entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Datphong> entities);

    void deleteAll();
}
