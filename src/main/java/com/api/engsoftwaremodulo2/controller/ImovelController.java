package com.api.engsoftwaremodulo2.controller;

import com.api.engsoftwaremodulo2.exception.ConstraintException;
import com.api.engsoftwaremodulo2.model.Imovel;
import com.api.engsoftwaremodulo2.service.ImovelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/imovel")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @GetMapping("/{codigo}")
    public ResponseEntity<Imovel> obterPorCodigo(@PathVariable
                                                 @NotBlank(message = "codigo nao pode ser vazio") String codigo) {

        Imovel imovel = this.imovelService.obterPorId(codigo);
        return ResponseEntity.ok(imovel);
    }

    @GetMapping
    public ResponseEntity<Collection<Imovel>> obterTodos() {
        List<Imovel> imoveis = this.imovelService.obterTodos();
        return ResponseEntity.ok(imoveis);
    }

    @PostMapping("/new")
    public ResponseEntity<Imovel> criar(@Valid @RequestBody Imovel imovel, BindingResult bindingResult) {
        this.checkBindingResultForErrors(bindingResult);

        Imovel novoImovel = this.imovelService.criar(imovel);
        return ResponseEntity.ok().body(novoImovel);
    }

    @PutMapping("/update")
    public ResponseEntity<Imovel> alterar(@Valid @RequestBody Imovel imovel, BindingResult bindingResult) {
        this.checkBindingResultForErrors(bindingResult);

        Imovel updatedImovel = this.imovelService.atualizar(imovel);
        return ResponseEntity.ok(updatedImovel);
    }

    @DeleteMapping("delete/{codigo}")
    public ResponseEntity<?> deletar(@PathVariable
                                      @NotBlank(message = "codigo nao pode ser vazio") String codigo) {
        this.imovelService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }

    private void checkBindingResultForErrors(BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());
    }
}