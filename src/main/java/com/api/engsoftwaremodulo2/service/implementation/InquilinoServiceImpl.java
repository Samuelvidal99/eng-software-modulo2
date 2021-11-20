package com.api.engsoftwaremodulo2.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.engsoftwaremodulo2.exception.ObjectNotFoundException;
import com.api.engsoftwaremodulo2.model.Inquilino;
import com.api.engsoftwaremodulo2.repository.InquilinoRepository;
import com.api.engsoftwaremodulo2.service.InquilinoService;

@Service
public class InquilinoServiceImpl implements InquilinoService {

	@Autowired
	private InquilinoRepository inquilinoRepository;
	
	@Override
	public Inquilino criar(Inquilino inquilino) {
		
		return inquilinoRepository.save(inquilino);
	}

	@Override
	public List<Inquilino> obterTodos() {
		return this.inquilinoRepository.findAll();
	}

	@Override
	public Inquilino obterPorCodigo(String codigo) {
		return this.inquilinoRepository.findById(codigo).orElseThrow(() -> new ObjectNotFoundException("Inquilino não Existe"));
	}

	@Override
	public void deletar(String codigo) {
		obterPorCodigo(codigo);
		this.inquilinoRepository.deleteById(codigo);

		
	}

	@Override
	public Inquilino atualizar(Inquilino inquilino) {
		obterPorCodigo(inquilino.getId());
		return this.inquilinoRepository.save(inquilino);
	}
	
	
}
