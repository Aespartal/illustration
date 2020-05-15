package net.ausiasmarch;

import javax.annotation.Resource;
import net.ausiasmarch.service.implementation.specific.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IllustrationApp {

    @Resource
    StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(IllustrationApp.class, args);
    }

}
