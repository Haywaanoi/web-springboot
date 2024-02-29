package com.example.demohotel.service;

import com.example.demohotel.model.Dichvu;
import com.example.demohotel.model.Phong;
import com.example.demohotel.repository.DichVuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DichVuServiceImpl implements DichVuService{
    DichVuRepository dichVuRepository;

    public DichVuServiceImpl(DichVuRepository dichVuRepository) {
        this.dichVuRepository = dichVuRepository;
    }

    @Override
    public List<Dichvu> findAll() {
        return dichVuRepository.findAll();
    }

    @Override
    public void deletebyId(Long id) {
       dichVuRepository.deleteById(id);
    }

    @Override
    public Dichvu findbyId(Long id) {
        Optional<Dichvu> opt = dichVuRepository.findById(id);
        Dichvu dichvu = null;
        if (opt.isPresent()) {
            dichvu = opt.get();
        } else {
            throw new RuntimeException("khong tim thay id nay");
        }
        return dichvu;
    }

    @Override
    public Dichvu save(Dichvu dichvu) {
        return dichVuRepository.save(dichvu);
    }
}
