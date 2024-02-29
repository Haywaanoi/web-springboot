package com.example.demohotel.service;

import com.example.demohotel.model.Loaiphong;
import com.example.demohotel.repository.LoaiPhongRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

@Service
public class LoaiPhongServiceImpl implements LoaiPhongService{
    private static final  String UPLOAD_DIR="src/main/resources/static/img/room";
    LoaiPhongRepository loaiPhongRepository;

    public LoaiPhongServiceImpl(LoaiPhongRepository loaiPhongRepository) {
        this.loaiPhongRepository = loaiPhongRepository;
    }

    @Override
    public List<Loaiphong> findByTenLoaiPhong(String name) {
        return loaiPhongRepository.findByTenLoaiPhong(name);
    }

    @Override
    public List<Loaiphong> findAll() {
        return loaiPhongRepository.findAll();
    }

    @Override
    public <S extends Loaiphong> S save(S entity) {
        return loaiPhongRepository.save(entity);
    }

    @Override
    public Loaiphong findById(Long aLong) {
        Optional<Loaiphong> opt=loaiPhongRepository.findById(aLong);
        Loaiphong loaiphong=null;
        if (opt.isPresent()){
            loaiphong=opt.get();
        }else {
            throw new RuntimeException("Không có id này");
        }
        return loaiphong;
    }

    @Override
    public boolean existsById(Long aLong) {
        return loaiPhongRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return loaiPhongRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        loaiPhongRepository.deleteById(aLong);
    }

    @Override
    public void delete(Loaiphong entity) {
        loaiPhongRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        loaiPhongRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Loaiphong> entities) {
        loaiPhongRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        loaiPhongRepository.deleteAll();
    }


    @Override
    public String saveFile(MultipartFile file) throws  IOException{
        //lay ten file
        String fileName=file.getOriginalFilename();

        //lay ten duong dan
        Path uploadPath=Path.of(UPLOAD_DIR).toAbsolutePath().normalize();

        //tao thu muc neu chua co
        if (!Files.exists(uploadPath)){
            try {
                Files.createDirectories(uploadPath);
            }catch (Exception e){
                throw  new RemoteException("Tao thu muc that bai");
            }
        }

        //luu file vao thu muc
        Path targetLocation=uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

}
