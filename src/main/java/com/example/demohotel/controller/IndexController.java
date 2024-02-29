package com.example.demohotel.controller;

import com.example.demohotel.config.service.MailService;
import com.example.demohotel.dto.KhachHangDTO;
import com.example.demohotel.model.Khachhang;
import com.example.demohotel.model.Loaiphong;
import com.example.demohotel.service.LoaiPhongService;
import com.example.demohotel.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@Controller
public class IndexController {
    private MailService mailService;

    private LoaiPhongService loaiPhongService;
    private UserService userService;

    @RequestMapping("/")
    public String getIndex(Model model){
        List<Loaiphong> listRandom=randomLoaiPhong(4);
        model.addAttribute("loaiphong",listRandom);
        return "index";
    }


    @GetMapping("/view-rooms")
    public String viewRooms(Model model){
        List<Loaiphong> dsloai=loaiPhongService.findAll();
        model.addAttribute("dsloai",dsloai);
        return "room-details";
       // return "redirect:/danhsach";

    }
    @GetMapping("/about-us")
    public String getAboutUs(){
        return "about-us";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }
    @PostMapping("/sendmail")
    public String sendMail(@RequestParam("yourname") String yourname,
                           @RequestParam("to") String to,
                           @RequestParam("content") String content
                           ){
        try {
            mailService.send(to,yourname,content);
            return "redirect:/contact";
        }catch (MailException e){
            e.printStackTrace();
            return "redirect:/error";
        }
    }
    @GetMapping("/showlogin")
    public String getLogin(){
        return "login-page";
    }
    @GetMapping("/access-denied")
    public String getAccessDenied(){
        return "access-denied";
    }

    //Dang ky nguoi dung
    @GetMapping("/register")
    public String getRegister(Model model){
        KhachHangDTO khachhang=new KhachHangDTO();
        model.addAttribute("guest",khachhang);
        return "register";
    }

    @PostMapping("/register/add")
    public String addCustomer(@ModelAttribute("guest") KhachHangDTO khachhangdto){
        Khachhang khachhang=new Khachhang();
        if (khachhangdto.getMatKhau().equals(khachhangdto.getXacnhanmatkhau())){
            khachhang.setHoTen(khachhangdto.getHoTen());
            khachhang.setEmail(khachhangdto.getEmail());
            khachhang.setSoDienThoai(khachhangdto.getSoDienThoai());
            khachhang.setTenDangNhap(khachhangdto.getTenDangNhap());
            khachhang.setMatKhau(khachhangdto.getMatKhau());
            khachhang.setRole("USER");
            userService.save(khachhang);
            return "redirect:/showlogin";
        }
        return "redirect:/register";
    }
    @GetMapping("/error")
    public String getError(Model model, HttpServletRequest request){
        // Lấy giá trị lỗi từ HttpServletRequest
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        if (statusCode != null) {
            if (statusCode == 404) {
                model.addAttribute("errorCode", "404");
                model.addAttribute("errorMessage", "Page Not Found");
            } else if (statusCode == 500) {
                model.addAttribute("errorCode", "500");
                model.addAttribute("errorMessage", "Internal Server Error");
            } else {
                model.addAttribute("errorCode", "Unknown");
                model.addAttribute("errorMessage", "Unknown Error");
            }
        }

        return "error";
    }
    //random phong de hien thi
    private List<Loaiphong> randomLoaiPhong(int count){
        List<Loaiphong> allLoaiphongs = loaiPhongService.findAll();
        List<Loaiphong> randomLoaiphongs = new ArrayList<>();
        Set<Integer> chosenIndexes = new HashSet<>();
        Random random = new Random();

        int size = allLoaiphongs.size();

        // Lấy ra count đối tượng ngẫu nhiên không trùng lặp từ danh sách allLoaiphongs
        for (int i = 0; i < count && i < size; i++) {
            int randomIndex;
            do {
                randomIndex = random.nextInt(size);
            } while (chosenIndexes.contains(randomIndex));

            chosenIndexes.add(randomIndex);
            randomLoaiphongs.add(allLoaiphongs.get(randomIndex));
        }

        return randomLoaiphongs;
    }
}
