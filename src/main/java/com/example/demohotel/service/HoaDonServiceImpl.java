package com.example.demohotel.service;

import com.example.demohotel.model.Hoadon;
import com.example.demohotel.repository.HoaDonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HoaDonServiceImpl implements HoaDonService{
    private HoaDonRepository hoaDonRepository;


    @Override
    public List<Hoadon> findAll() {
        return hoaDonRepository.findAll();
    }

    @Override
    public <S extends Hoadon> S save(S entity) {
        return hoaDonRepository.save(entity);
    }

    @Override
    public Hoadon findById(Long aLong) {
        Optional<Hoadon> opt = hoaDonRepository.findById(aLong);
        Hoadon hoadon = null;
        if (opt.isPresent()) {
            hoadon = opt.get();
        } else {
            throw new RuntimeException("khong tim thay id nay");
        }
        return hoadon;
    }

    @Override
    public boolean existsById(Long aLong) {
        return hoaDonRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return hoaDonRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        hoaDonRepository.deleteById(aLong);
    }

    @Override
    public void delete(Hoadon entity) {
        hoaDonRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        hoaDonRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Hoadon> entities) {
        hoaDonRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        hoaDonRepository.deleteAll();
    }

}
