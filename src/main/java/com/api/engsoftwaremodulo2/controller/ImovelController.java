package com.api.engsoftwaremodulo2.controller;

import com.api.engsoftwaremodulo2.exception.CepInvalidoException;
import com.api.engsoftwaremodulo2.exception.ConstraintException;
import com.api.engsoftwaremodulo2.model.Imovel;
import com.api.engsoftwaremodulo2.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/imovel")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping("/criar")
    public ResponseEntity<Imovel> criar(@Valid @RequestBody Imovel imovel, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        Imovel novoImovel = this.imovelService.criar(imovel);
        return ResponseEntity.ok().body(novoImovel);
    }
}
