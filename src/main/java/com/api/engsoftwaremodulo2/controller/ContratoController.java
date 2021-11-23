package com.api.engsoftwaremodulo2.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.engsoftwaremodulo2.exception.ConstraintException;
import com.api.engsoftwaremodulo2.model.Contrato;
import com.api.engsoftwaremodulo2.service.ContratoService;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

	@Autowired
	private ContratoService contratoService;
	
	@GetMapping
	public ResponseEntity<Collection<Contrato>> obterTodos()
	{
		Collection<Contrato> collection = this.contratoService.obterTodos();
		
		return ResponseEntity.ok().body(collection);
	}
	
	
	@PostMapping("/new")
	public ResponseEntity<Contrato> criar(@Valid @RequestBody Contrato contrato, BindingResult br)
	{
		if(br.hasErrors())
		{
			throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		}
		
		contrato = this.contratoService.criar(contrato);
		
		return ResponseEntity.ok().body(contrato);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Contrato> obterPorCodigo(@PathVariable String codigo)
	{
		return ResponseEntity.ok().body(this.contratoService.obterPorCodigo(codigo));
		
	}
	
	@DeleteMapping("delete/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable String codigo)
	{
		
		this.contratoService.deletar(codigo);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Contrato> atualizar(@Valid @RequestBody Contrato contrato, BindingResult br)
	{
		if(br.hasErrors())
		{
			throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		}
		
		contrato = this.contratoService.atualizar(contrato);
		
		return ResponseEntity.ok().body(contrato);
	}
	
}
