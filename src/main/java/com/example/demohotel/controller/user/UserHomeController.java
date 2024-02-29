package com.example.demohotel.controller.user;

import com.example.demohotel.model.Datphong;
import com.example.demohotel.model.Khachhang;
import com.example.demohotel.service.DatPhongService;
import com.example.demohotel.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHomeController {
    UserService userService;
    DatPhongService datPhongService;

    public UserHomeController(UserService userService, DatPhongService datPhongService) {
        this.userService = userService;
        this.datPhongService = datPhongService;
    }


    @GetMapping("/profile")
    public String getUserHome(Model model, Authentication authentication){
        String name = authentication.getName();
        Khachhang khachhang = userService.findByName(name);
        model.addAttribute("Khachhang", khachhang);
        return "user-profile";
    }
    @PostMapping("/save")
    public String UserSave(@ModelAttribute("Khachhang") Khachhang khachhang)
    {
        userService.save(khachhang);
        return "redirect:/user/profile";
    }
    @GetMapping("/capnhat")
    public String UserCapNhat(Model model, @RequestParam("id") Long id)
    {
        Khachhang khachhang = userService.findbyId(id);
        khachhang.setId(id);
        model.addAttribute("Khachhang", khachhang);
        return "capnhat-user";
    }


}
