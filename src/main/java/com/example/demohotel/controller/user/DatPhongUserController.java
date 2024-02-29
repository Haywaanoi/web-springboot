package com.example.demohotel.controller.user;

import com.example.demohotel.model.Datphong;
import com.example.demohotel.model.Dichvu;
import com.example.demohotel.model.Khachhang;
import com.example.demohotel.model.Phong;
import com.example.demohotel.service.DatPhongService;
import com.example.demohotel.service.DichVuService;
import com.example.demohotel.service.PhongService;
import com.example.demohotel.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/user")
public class DatPhongUserController {
    DatPhongService datPhongService;
    DichVuService dichVuService;
    PhongService phongService;
    UserService userService;

    public DatPhongUserController(DatPhongService datPhongService, DichVuService dichVuService, PhongService phongService, UserService userService) {
        this.datPhongService = datPhongService;
        this.dichVuService = dichVuService;
        this.phongService = phongService;
        this.userService = userService;
    }

    @PostMapping("/datphong")
    public String saveDatPhong(@ModelAttribute("datphong") Datphong datphong) {
        datphong.setNgayTao(LocalDate.now());
        datPhongService.save(datphong);
        return "redirect:/";
    }


    @GetMapping("/booking")
    public String booking(@RequestParam("id")Long id,
                          @RequestParam("checkIn") LocalDate checkIn,
                          @RequestParam("checkOut") LocalDate checkOut,
                          Model model, Authentication authentication){
        String username = authentication.getName();
        Datphong datphong = new Datphong();

        Phong phong = phongService.findbyId(id);
        List<Dichvu> dichvus = dichVuService.findAll();

        Khachhang khachhang = userService.findByName(username);
        phong.setId(id);
        model.addAttribute("DatPhong", datphong);
        model.addAttribute("DichVu", dichvus);
        model.addAttribute("maKhachHang",khachhang);
        model.addAttribute("maPhong", phong);
        model.addAttribute("ngayNhanPhong", checkIn);
        model.addAttribute("ngayTraPhong", checkOut);
        return "FormDatPhong";
    }
}
