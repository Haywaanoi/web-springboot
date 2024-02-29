package com.example.demohotel.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class KhachHangDTO {

    private Long id;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String tenDangNhap;
    private String matKhau;
    private String xacnhanmatkhau;
    private String role;

}
