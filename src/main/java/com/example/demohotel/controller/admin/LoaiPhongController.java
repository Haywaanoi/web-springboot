package com.example.demohotel.controller.admin;

import com.example.demohotel.model.Loaiphong;
import com.example.demohotel.service.LoaiPhongService;
import com.example.demohotel.ultis.UploadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class LoaiPhongController {
    private LoaiPhongService loaiPhongService;
    private UploadService uploadService;

    @GetMapping("/view-rooms")
    public String viewRooms(Model model){
        List<Loaiphong> dsloai=loaiPhongService.findAll();
        model.addAttribute("dsloai",dsloai);
        return "admin-template/admin-view-room-details";
    }
    @PostMapping ("/view-rooms/save")
    public String saveLoaiphong(@RequestParam("tenloai") String tenloai, @RequestParam("mota") String mota, @RequestParam("giaphong") BigDecimal giaphong, @RequestParam("anhphong") MultipartFile anhphong,Model model) throws IOException {

        try {
            String tenanh=uploadService.uploadFile(anhphong);

            Loaiphong loaiphong=new Loaiphong();
            loaiphong.setTenLoaiPhong(tenloai);
            loaiphong.setMoTaLoaiPhong(mota);
            loaiphong.setDuongDanHinhAnh(tenanh);
            loaiphong.setGiaLoaiPhong(giaphong);
            loaiPhongService.save(loaiphong);
            return "redirect:/admin/view-rooms";
        }catch (Exception e){
            String message="Add failed!";
            model.addAttribute("error",message);
            return "redirect:/admin/view-rooms";
        }
    }
    @GetMapping("/view-rooms/delete/{id}")
    public String deleteRoom(@PathVariable("id") Long id){
        try {
            loaiPhongService.deleteById(id);
            return "redirect:/admin/view-rooms";
        }  catch (Exception e){
            return "redirect:/admin/view-rooms";
        }

    }
    @GetMapping("/view-rooms/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model) {
        Loaiphong loaiphong=loaiPhongService.findById(id);
        loaiphong.setId(id);
        model.addAttribute("loaiphong",loaiphong);
        return "admin-template/admin-update-room-type";
    }
    @PostMapping("/view-rooms/update")
    public String updateRoomType(@ModelAttribute("loaiphong") Loaiphong loaiphong) {
        loaiPhongService.save(loaiphong);
        return "redirect:/admin/view-rooms";
    }
    @GetMapping("/admin/tim-kiem")
    public String findPhong(Model model,@RequestParam("name") String name){
        List<Loaiphong> dsPhong=loaiPhongService.findByTenLoaiPhong(name);
        model.addAttribute("phong",dsPhong);
        return "admin-template/admin-view-room-details";
    }
}
