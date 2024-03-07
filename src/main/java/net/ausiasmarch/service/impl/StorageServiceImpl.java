/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl {

    private final Path rootLocation = Paths.get("src\\main\\resources\\image");
    
    public Boolean uploadFile(MultipartFile file) throws Exception {
        Boolean state;
        try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            state = true;
        } catch (IOException e) {
            e.printStackTrace();
            state = false;
        }
        return state;
    }

}
