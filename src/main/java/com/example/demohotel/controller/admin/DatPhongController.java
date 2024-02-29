package com.example.demohotel.controller.admin;

import com.example.demohotel.model.Datphong;
import com.example.demohotel.service.DatPhongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class DatPhongController {
    private DatPhongService datPhongService;

    @RequestMapping("/list-datphong")
    public String getDatPhong(Model model){
        List<Datphong> dsDatphong=datPhongService.findAll();
        model.addAttribute("dsDatPhong",dsDatphong);
        return "admin-template/admin-booking-list";
    }
    @GetMapping("/list-datphong/delete/{id}")
    public String deleteDatPhong(@PathVariable("id") Long id){
        datPhongService.deleteById(id);
        return "redirect:/admin/list-datphong";
    }
}
