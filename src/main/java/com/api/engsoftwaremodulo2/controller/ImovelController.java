package com.api.engsoftwaremodulo2.controller;

import com.api.engsoftwaremodulo2.model.Imovel;
import com.api.engsoftwaremodulo2.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/imovel")
@CrossOrigin(origins = "*")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping("/criar")
    public Imovel criar(@RequestBody Imovel imovel) {
        return this.imovelService.criar(imovel);
    }
}
