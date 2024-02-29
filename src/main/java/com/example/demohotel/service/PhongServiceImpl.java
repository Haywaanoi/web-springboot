package com.example.demohotel.service;

import com.example.demohotel.model.Loaiphong;
import com.example.demohotel.model.Phong;
import com.example.demohotel.repository.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongServiceImpl implements PhongService{
    PhongRepository phongRepository;
    @Autowired
    public PhongServiceImpl(PhongRepository phongRepository) {
        this.phongRepository = phongRepository;
    }

    @Override
    public List<Phong> findAll() {
        return phongRepository.findAll();
    }

    @Override
    public void deletebyId(Long id) {
        phongRepository.deleteById(id);
    }

    @Override
    public Phong findbyId(Long id) {
        Optional<Phong> opt = phongRepository.findById(id);
        Phong phong = null;
        if (opt.isPresent()) {
            phong = opt.get();
        } else {
           throw new RuntimeException("khong tim thay id nay");
        }
        return phong;
    }


    @Override
    public Phong save(Phong phong) {
        return phongRepository.save(phong);
    }

    @Override
    public List<Phong> findByName(String name) {
        List<Phong> opt= phongRepository.findByTenPhong(name);
        return opt;
    }

    @Override
    public List<Phong> findByLoaiPhongId(Loaiphong id) {
        return phongRepository.findByLoaiPhongID(id);
    }


}
