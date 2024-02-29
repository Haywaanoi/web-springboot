package com.example.demohotel.service;

import com.example.demohotel.model.Datphong;
import com.example.demohotel.repository.DatPhongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DatPhongServiceImpl implements DatPhongService{
    private DatPhongRepository datPhongRepository;

    @Override
    public List<Datphong> findAll() {
        return datPhongRepository.findAll();
    }



    @Override
    public <S extends Datphong> S save(S entity) {
        return datPhongRepository.save(entity);
    }

    @Override
    public Datphong findById(Long aLong) {
        Optional<Datphong> opt = datPhongRepository.findById(aLong);
        Datphong datphong = null;
        if (opt.isPresent()) {
            datphong = opt.get();
        } else {
            throw new RuntimeException("khong tim thay id nay");
        }
        return datphong;
    }

    @Override
    public boolean existsById(Long aLong) {
        return datPhongRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return datPhongRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        datPhongRepository.deleteById(aLong);
    }

    @Override
    public void delete(Datphong entity) {
        datPhongRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        datPhongRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Datphong> entities) {
        datPhongRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        datPhongRepository.deleteAll();
    }
}
