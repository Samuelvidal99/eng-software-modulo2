package com.api.engsoftwaremodulo2.service;

import java.util.List;

import com.api.engsoftwaremodulo2.model.Contrato;


public interface ContratoService {

	public List<Contrato> obterTodos();
	
	public Contrato obterPorCodigo(String codigo);
	
	public Contrato criar(Contrato contrato);
	
	public void deletar(String codigo);
	
	public Contrato atualizar(Contrato contrato);
}
