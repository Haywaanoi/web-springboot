package com.example.demohotel.dto;

import com.example.demohotel.model.Phong;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaiPhongDTO {
    private Long id;
    private String tenLoaiPhong;
    private String moTaLoaiPhong;
    private BigDecimal giaLoaiPhong;
    private String duongDanHinhAnh;
    private Set<Phong> phongs ;
}
