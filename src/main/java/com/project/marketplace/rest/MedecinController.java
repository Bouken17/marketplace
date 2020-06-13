package com.project.marketplace.rest;

import com.google.gson.Gson;
import com.project.marketplace.entity.Medecin;
import com.project.marketplace.service.MedecinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecin")
public class MedecinController {
    private final MedecinService medecinService;

    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @GetMapping("getAll")
    public List<Medecin> getAllMedecins() {
        return this.medecinService.getAllMedecins();
    }

    @GetMapping("get/{id}")
    public Medecin getMedecin(@PathVariable("id") long id){
        return this.medecinService.getMedecin(id);
    }


    @GetMapping("get/{email}")
    public Medecin getMedecinByEmail(@PathVariable("login") String login){
        return this.medecinService.getMedecin(login);
    }

    @GetMapping("logging")
    public Medecin loggingMedecin(@RequestParam("login") String login,@RequestParam("password") String password){
        return this.medecinService.getMedecin(login, password);
    }
//
//    @GetMapping("logging")
//    public Boolean loggingMedecin(@RequestParam("login") String login,@RequestParam("password") String password){
//        if(this.medecinService.getMedecin(login, password).equals(null)){
//            return false;
//        }else {
//            return true;
//        }
//    }

    @PostMapping("add")
    public Medecin increment(@RequestParam("data") String data) {
        Medecin medecin = new Gson().fromJson(data, Medecin.class);
        return this.medecinService.addMedecin(medecin);
    }

}
