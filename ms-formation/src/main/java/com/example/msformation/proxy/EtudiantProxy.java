package com.example.msformation.proxy;

import com.example.msformation.Model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="ms-scolarite", url="localhost:8082")
public interface EtudiantProxy {

    @GetMapping("etudiants/search/findEtudiantsByIdFormation")
    CollectionModel<Etudiant> getEtudiants(@RequestParam("idf") Long idf,
                                           @RequestParam("projection") String projection);

}
