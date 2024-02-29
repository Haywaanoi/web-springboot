package com.example.demohotel.controller.admin;

import com.example.demohotel.model.Dichvu;
import com.example.demohotel.service.DichVuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DichVuController {
    DichVuService dichVuService;

    public DichVuController(DichVuService dichVuService) {
        this.dichVuService = dichVuService;
    }

    @GetMapping("/dichvu")
    public String listDichVu(Model model)
    {
        List<Dichvu> dichvu = dichVuService.findAll();
        model.addAttribute("dsDichvu", dichvu);
        return "admin-template/admin-view-dichvu-list";
    }
    @GetMapping("/dichvu/delete")
    public String deleteDichvu(@RequestParam("id") Long id) {
        dichVuService.deletebyId(id);
        return "redirect:/admin/dichvu";

    }

    @PostMapping("/dichvu/edit")
    public String editDichvu(@ModelAttribute("dichvu") Dichvu dichvu) {

        dichVuService.save(dichvu);
        return "redirect:/admin/dichvu";
    }
    @GetMapping("/dichvu/add")
    public String add(Model model)
    {
        Dichvu dichvu = new Dichvu();
        List<Dichvu> listdichvu = dichVuService.findAll();
        model.addAttribute("dichvu",dichvu);
        return "admin-template/admin-edit-dichvu";

    }
    @GetMapping("/dichvu/update")
    public String update(@RequestParam("id")Long id,Model model)
    {
        Dichvu dichvu = dichVuService.findbyId(id);
        dichvu.setId(id);
        model.addAttribute("dichvu", dichvu);

        return "admin-template/admin-edit-dichvu";
    }
}
