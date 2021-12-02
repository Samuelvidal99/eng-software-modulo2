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
import com.api.engsoftwaremodulo2.model.Inquilino;
import com.api.engsoftwaremodulo2.service.InquilinoService;

@RestController
@RequestMapping("/inquilino")
public class InquilinoController {

	@Autowired
	private InquilinoService inquilinoService;
	
	
	@GetMapping
	public ResponseEntity<Collection<Inquilino>> obterTodos()
	{
		Collection<Inquilino> collection = this.inquilinoService.obterTodos();
		
		return ResponseEntity.ok().body(collection);
	}
	
	
	
	@PostMapping("/new")
	public ResponseEntity<Inquilino> criar(@Valid @RequestBody Inquilino inquilino, BindingResult br)
	{
		if(br.hasErrors())
		{
			throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		}
		
		inquilino = this.inquilinoService.criar(inquilino);
		
		return ResponseEntity.ok().body(inquilino);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Inquilino> obterPorCodigo(@PathVariable String codigo)
	{
		return ResponseEntity.ok().body(this.inquilinoService.obterPorCodigo(codigo));
		
	}
	
	@DeleteMapping("delete/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable String codigo)
	{
		
		this.inquilinoService.deletar(codigo);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Inquilino> atualizar(@Valid @RequestBody Inquilino inquilino, BindingResult br)
	{
		if(br.hasErrors())
		{
			throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		}
		
		inquilino = this.inquilinoService.atualizar(inquilino);
		
		return ResponseEntity.ok().body(inquilino);
	}
	
}