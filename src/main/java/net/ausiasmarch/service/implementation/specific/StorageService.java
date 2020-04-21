/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.service.implementation.specific;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

    private final String fileBasePath = "C:\\xampp\\htdocs\\illustration-client\\src\\assets\\images\\";

    public Boolean uploadFile(MultipartFile file) throws Exception {
        Boolean state = false;

	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	Path path = Paths.get(fileBasePath + fileName);
        
	try {
            if(Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING)!=0){
                state = true;
            }          
	} catch (IOException e) {
		e.printStackTrace();
	}

        return state;
    }
}
