package com.api.engsoftwaremodulo2.service;

import java.util.List;

import com.api.engsoftwaremodulo2.model.Inquilino;

public interface InquilinoService {
	
	public List<Inquilino> obterTodos();
	
	public Inquilino obterPorCodigo(String codigo);
	
	public Inquilino criar(Inquilino inquilino);
	
	public void deletar(String codigo);
	
	public Inquilino atualizar(Inquilino inquilino);
}
