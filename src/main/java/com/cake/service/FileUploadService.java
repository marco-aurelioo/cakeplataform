package com.cake.service;

import com.cake.entity.FileEntity;
import com.cake.repository.FileRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileUploadService {

    @Autowired
    private FileRepository repository;

    public FileEntity salve(MultipartFile arquivo) throws IOException {
        String fileName = StringUtils.cleanPath(arquivo.getOriginalFilename());
        FileEntity file = new FileEntity(fileName,arquivo.getContentType(),arquivo.getBytes());
        return repository.save(file);
    }

    public FileEntity recuperaArquivo(String id) throws NotFoundException {
        Optional<FileEntity> byId = repository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        throw new NotFoundException("arquivo não encontrado:'"+id+"'");
    }


}
