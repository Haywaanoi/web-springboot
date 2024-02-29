package com.example.demohotel.service;

import com.example.demohotel.model.Admin;
import com.example.demohotel.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{
    private AdminRepository adminRepository;


    @Override
    public boolean existsByTenDangNhap(String tenDangNhap) {
        return adminRepository.existsByTenDangNhap(tenDangNhap);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public <S extends Admin> S save(S entity) {
        return adminRepository.save(entity);
    }

    @Override
    public Admin findById(Long aLong) {
        Optional<Admin> opt=adminRepository.findById(aLong);
        Admin admin=null;
        if (opt.isPresent()){
            admin=opt.get();
        }else {
            throw new RuntimeException("Khong co id nay");
        }
        return admin;
    }

    @Override
    public boolean existsById(Long aLong) {
        return adminRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return adminRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        adminRepository.deleteById(aLong);
    }

    @Override
    public void delete(Admin entity) {
        adminRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        adminRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Admin> entities) {
        adminRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        adminRepository.deleteAll();
    }
}
