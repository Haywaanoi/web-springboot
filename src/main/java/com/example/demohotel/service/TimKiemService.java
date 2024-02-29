package com.example.demohotel.service;

import com.example.demohotel.model.Phong;

import java.time.LocalDate;
import java.util.List;

public interface TimKiemService {
    public List<Phong> findAvailableRoom(LocalDate checkInDate, LocalDate checkOutDate);
}
