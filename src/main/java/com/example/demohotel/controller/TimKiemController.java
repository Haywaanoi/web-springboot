package com.example.demohotel.controller;

import com.example.demohotel.model.Phong;
import com.example.demohotel.service.TimKiemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TimKiemController {
    @Autowired
    private TimKiemService timKiemService;

    public TimKiemController(TimKiemService timKiemService) {
        this.timKiemService = timKiemService;
    }
    @GetMapping("/timkiem")
    public String showTimKiemPhongPage() {
        return "timkiemphong"; // Trả về tên của trang HTML tìm kiếm phòng
    }
    @GetMapping("/danhsach")
    public String timKiemPhong(
            @RequestParam("checkInDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate checkInDate,
            @RequestParam("checkOutDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate checkOutDate,
            Model model){
        List<Phong> phongTrong = timKiemService.findAvailableRoom(checkInDate,checkOutDate);
        model.addAttribute("phongTrong", phongTrong);
        model.addAttribute("checkInDate", checkInDate);
        model.addAttribute("checkOutDate",checkOutDate);
        return "danhsachphong";
    }


}

