package com.example.dossier.app;

import com.example.dossier.DossierBasePackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {DossierBasePackage.class})
public class DossierApplication {

    public static void main(String[] args) {
        SpringApplication.run(DossierApplication.class);
    }
}
