package com.example.msformation;

import com.example.msformation.entities.Formation;
import com.example.msformation.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsFormationApplication implements CommandLineRunner {

    @Autowired
    FormationRepository formationRepository;
    public static void main(String[] args) {
        SpringApplication.run(MsFormationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Formation f1=  formationRepository.save(new Formation(null, "Java",30,null));
        Formation f2=formationRepository.save(new Formation(null, "Angular",40,null));

    }
}
