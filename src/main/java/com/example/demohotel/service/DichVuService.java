package com.example.demohotel.service;

import com.example.demohotel.model.Dichvu;
import com.example.demohotel.model.Phong;
import com.example.demohotel.repository.HoaDonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DichVuService {

    List<Dichvu> findAll();

    void deletebyId(Long id);

    Dichvu findbyId(Long id);

    Dichvu save(Dichvu dichvu);

}
