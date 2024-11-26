package com.project.file_service.controller;

import com.project.file_service.entity.FileEntity;
import com.project.file_service.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@CrossOrigin("*")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload/{id}/{type}")
    public int saveFile(@PathVariable long id,
                        @PathVariable int type,
                        @RequestParam("file") MultipartFile file) {
        try {
            return fileService.uploadFile(id, type, file);
        } catch (IOException e) {
            return 0;
        }
    }

    @GetMapping("/download/{id}/{type}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable long id,
                                               @PathVariable int type) {
        FileEntity pdfFile = fileService.downloadFile(id,type);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pdfFile.getFilename() + "\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfFile.getFileContent());
    }

    @DeleteMapping("/delete/{id}")
    public int deleteFiles(@PathVariable long id){
        try{
            fileService.deleteFiles(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
