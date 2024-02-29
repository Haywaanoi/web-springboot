package com.example.demohotel.service;

import com.example.demohotel.model.Khachhang;
import com.example.demohotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Override
    public boolean existsByTenDangNhap(String tenDangNhap) {
        return userRepository.existsByTenDangNhap(tenDangNhap);
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Khachhang> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Khachhang findByName(String hoTen) {

        return userRepository.findByTenDangNhap(hoTen);
        }


    @Override
    public void deletebyId(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Khachhang findbyId(Long id) {
        Optional<Khachhang> opt = userRepository.findById(id);
        Khachhang khachhang = null;
        if(opt.isPresent())
        {
            khachhang = opt.get();
        }else
        {
            throw new RuntimeException("khong tim thay id nay");
        }
        return khachhang;
    }

    @Override
    public Khachhang save(Khachhang khachhang) {
        return userRepository.save(khachhang);
    }
}
