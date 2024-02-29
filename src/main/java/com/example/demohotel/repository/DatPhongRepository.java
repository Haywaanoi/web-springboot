package com.example.demohotel.repository;

import com.example.demohotel.model.Datphong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatPhongRepository extends JpaRepository<Datphong,Long> {

}
