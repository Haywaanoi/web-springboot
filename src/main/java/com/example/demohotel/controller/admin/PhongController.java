package com.example.demohotel.controller.admin;

import com.example.demohotel.model.Loaiphong;
import com.example.demohotel.model.Phong;
import com.example.demohotel.service.LoaiPhongService;
import com.example.demohotel.service.PhongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class PhongController {
    PhongService phongService;
    LoaiPhongService loaiPhongService;

    @GetMapping("/phong")
    public String viewRooms(Model model) {
        List<Phong> dsPhong = phongService.findAll();
        model.addAttribute("dsPhong", dsPhong);
        return "admin-template/admin-view-room-list";
    }

    @GetMapping("/phong/delete")
    public String deleteRoom(@RequestParam("id") Long id) {
        try {
            phongService.deletebyId(id);
        }catch (Exception e){

        }

        return "redirect:/admin/phong";
    }

    @PostMapping("/phong/edit")
    public String editRoom(@ModelAttribute("phong") Phong phong) {

       phongService.save(phong);
       return "redirect:/admin/phong";
    }
    @GetMapping("/phong/add")
    public String add(Model model)
    {
        Phong phong = new Phong();
        List<Loaiphong> listLoai = loaiPhongService.findAll();
        model.addAttribute("phong",phong);
        model.addAttribute("listLoai", listLoai);
        return "admin-template/admin-edit-room";

    }
    @GetMapping("/phong/update")
    public String update(@RequestParam("id")Long id,Model model) {
        List<Loaiphong> listLoai = loaiPhongService.findAll();
        Phong phong = phongService.findbyId(id);
        phong.setId(id);
        model.addAttribute("phong", phong);
        model.addAttribute("listLoai", listLoai);

        return "admin-template/admin-edit-room";
    }
    @GetMapping("/phong/loc")
    public String locLoaiPhong(@RequestParam("idLoai") Loaiphong id, Model model)
    {
        List<Loaiphong> dsLoai = loaiPhongService.findAll();
        List<Phong> dsPhong = phongService.findByLoaiPhongId(id);
        model.addAttribute("dsLoai", dsLoai);
        model.addAttribute("dsPhong", dsPhong);
        return "admin-template/admin-view-room-list";
    }
    @GetMapping("/phong/timkiem")
    public String timkiem(@RequestParam("name") String name, Model model)
    {
        List<Phong> dsPhong = phongService.findByName(name);
        model.addAttribute("ds", dsPhong );
        return "admin-template/admin-timkiem-room";
    }
}
