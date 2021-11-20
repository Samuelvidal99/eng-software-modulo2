package com.api.engsoftwaremodulo2.controller;

import com.api.engsoftwaremodulo2.service.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

@RestController
@RequestMapping("/conf")
@Validated
public class ConfiguracaoController {

    @Autowired
    private ConfiguracaoService confService;

    @PostMapping("/email/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestParam("email") @Email String email) {
        return ResponseEntity.ok().body(confService.cadastrar(email));
    }

    @PutMapping("/email/alterar")
    public ResponseEntity<String> alterar(@RequestParam("email") @Email String email) {
        return ResponseEntity.ok().body(confService.cadastrar(email));
    }
}
