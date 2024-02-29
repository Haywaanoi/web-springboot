package com.example.demohotel.controller.admin;

import com.example.demohotel.model.Hoadon;
import com.example.demohotel.service.HoaDonService;
import com.example.demohotel.service.LoaiPhongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class HoaDonController {
    private HoaDonService hoaDonService;

    @GetMapping("/list-invoices")
    public String getHoaDon(Model model){
        List<Hoadon> listHoaDon=hoaDonService.findAll();
        model.addAttribute("dsHoaDon",listHoaDon);
        return "admin-template/admin-invoices";
    }
    @GetMapping("/invoice/delete/{id}")
    public String deleteInvoice(@PathVariable("id") Long id){
        try {
            hoaDonService.deleteById(id);
        }catch (Exception e){

        }
        return "redirect:/admin/list-invoices";
    }
}
