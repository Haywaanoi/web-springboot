package com.example.demohotel.controller.admin;

import com.example.demohotel.model.Admin;
import com.example.demohotel.model.Dichvu;
import com.example.demohotel.model.Khachhang;
import com.example.demohotel.model.Loaiphong;
import com.example.demohotel.service.AdminService;
import com.example.demohotel.service.LoaiPhongService;
import com.example.demohotel.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class UserController {
    private UserService userService;
    private AdminService adminService;
    //admin
    @RequestMapping("/view-admin")
    public String getAdminList(Model model){
        List<Admin> listadmin=adminService.findAll();
        model.addAttribute("listadmin",listadmin);
        return "admin-template/admin-view-admin-list";
    }
    @PostMapping("/view-admin/save")
    public String addAdmin(@RequestParam("name") String hoten,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password){
        Admin admin=new Admin();
        admin.setHoTen(hoten);
        admin.setTenDangNhap(username);
        admin.setMatKhau(password);
        admin.setRole("ADMIN");
        adminService.save(admin);
        return "redirect:/admin/view-admin";
    }
    @GetMapping("/view-admin/delete/{id}")
    public String deleteAdmin(@PathVariable("id") Long id){
        adminService.deleteById(id);
        return "redirect:/admin/view-admin";
    }
    @RequestMapping("/view-admin/edit/{id}")
    public String editAdmin(@PathVariable("id") Long id,Model model){
        Admin admin=adminService.findById(id);
        admin.setId(id);
        admin.setRole("ADMIN");
        model.addAttribute("admin",admin);
        return "admin-template/admin-edit-adminacc";
    }

    @PostMapping("/view-admin/update")
    public String updateAdmin(@ModelAttribute("admin") Admin admin) {
        adminService.save(admin);
        return "redirect:/admin/home";
    }

    //khach hang
    @GetMapping("/khachhang")
    public String khachhang(Model model)
    {
        List<Khachhang> listUser = userService.findAll();
        model.addAttribute("listUser", listUser);
        return "admin-template/admin-view-User";
    }
    @PostMapping("/khachhang/edit")
    public String editKhachhang(@ModelAttribute("khachhang") Khachhang khachhang) {

        userService.save(khachhang);
        return "redirect:/admin/khachhang";
    }
    @GetMapping("/khachhang/add")
    public String add(Model model)
    {

        Khachhang khachhang = new Khachhang();

        khachhang.setRole("USER");
        List<Khachhang> listUser = userService.findAll();
        model.addAttribute("khachhang",khachhang);
        return "admin-template/admin-edit-User";

    }
    @GetMapping("/khachhang/update")
    public String update(@RequestParam("id")Long id,Model model)
    {
        Khachhang khachhang = userService.findbyId(id);
        khachhang.setId(id);
        model.addAttribute("khachhang", khachhang);
        return "admin-template/admin-edit-User";
    }
}
