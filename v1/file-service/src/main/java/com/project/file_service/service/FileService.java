package com.project.file_service.service;

import com.project.file_service.entity.FileEntity;
import com.project.file_service.repository.FileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    public int uploadFile(long creditId,int type,MultipartFile file) throws IOException {
        FileEntity newFile = new FileEntity();
        newFile.setCreditId(creditId);
        newFile.setType(type);
        newFile.setFilename(file.getOriginalFilename());
        newFile.setFileContent(file.getBytes());
        fileRepository.save(newFile);
        return 1;
    }

    @Transactional
    public FileEntity downloadFile(long creditId, int type){
        return fileRepository.findByCreditIdAndType(creditId,type);
    }

    public int deleteFiles(long creditId) throws Exception {
        try{
            fileRepository.deleteByCreditId(creditId);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
