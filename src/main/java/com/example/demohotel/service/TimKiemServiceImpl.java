package com.example.demohotel.service;

import com.example.demohotel.model.Phong;
import com.example.demohotel.repository.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TimKiemServiceImpl implements TimKiemService{

    @Autowired
    private PhongRepository phongRepository;

    @Override
    public List<Phong> findAvailableRoom(LocalDate checkInDate, LocalDate checkOutDate) {
        return phongRepository.findAvailableRooms(checkInDate,checkOutDate);
    }
}
