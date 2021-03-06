package tn.esprit.dari.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.service.IUtilisateurService;
import tn.esprit.dari.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/UserCrud/")
@AllArgsConstructor
public class UserController {

    @Autowired
    UtilisateurService utilisateurService;

    @GetMapping("/getallUsers/{user-id}")
    public Utilisateur getallUsers(@PathVariable("user-id") Long id)
    {
        return utilisateurService.getuserbyId(id);

    }



}
