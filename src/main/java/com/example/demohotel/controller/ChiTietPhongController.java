package com.example.demohotel.controller;

import com.example.demohotel.model.Khachhang;
import com.example.demohotel.model.Loaiphong;
import com.example.demohotel.model.Phong;
import com.example.demohotel.repository.UserRepository;
import com.example.demohotel.service.LoaiPhongService;
import com.example.demohotel.service.PhongService;
import com.example.demohotel.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class ChiTietPhongController {
    PhongService phongService;
    LoaiPhongService loaiPhongService;
    UserService userService;
    UserRepository userRepository;

    public ChiTietPhongController(PhongService phongService, LoaiPhongService loaiPhongService, UserService userService, UserRepository userRepository) {
        this.phongService = phongService;
        this.loaiPhongService = loaiPhongService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/chitietphong")
    public String Chitiet(@RequestParam("id")Long id,
                          @RequestParam("checkIn") LocalDate checkIn,
                          @RequestParam("checkOut") LocalDate checkOut,
                          Model model)
    {
        Phong phong = phongService.findbyId(id);
        phong.setId(id);
        model.addAttribute("phong", phong);
        model.addAttribute("checkIn", checkIn);
        model.addAttribute("checkOut", checkOut);
        return "chitietphong";
    }
    @GetMapping("/chitietphong/{id}")
    public String getChitiet(@PathVariable("id") Long id, Model model)
    {
        Phong phong = phongService.findbyId(id);
        phong.setId(id);
        model.addAttribute("phong", phong);
        return "chitietphong";
    }



}
