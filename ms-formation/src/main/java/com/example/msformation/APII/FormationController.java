package com.example.msformation.APII;

import com.example.msformation.Model.Etudiant;
import com.example.msformation.entities.Formation;
import com.example.msformation.proxy.EtudiantProxy;
import com.example.msformation.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class FormationController {

    @Autowired
    FormationRepository formationRepository;
    @Autowired
    EtudiantProxy etudiantProxy;

    @GetMapping("formations/{idf}")
    Formation getFormationWithStudents(@PathVariable("idf") Long idf)
    {
        Formation formation= formationRepository.findById(idf).get();

        List<Etudiant> etudiants=new ArrayList(
                etudiantProxy.getEtudiants(idf, "toformation").getContent());
         formation.setEtudiants(etudiants);

        return  formation;
    }
}
