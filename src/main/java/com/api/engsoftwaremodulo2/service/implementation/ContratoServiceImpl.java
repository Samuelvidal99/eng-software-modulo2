package com.api.engsoftwaremodulo2.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.engsoftwaremodulo2.exception.ObjectNotFoundException;
import com.api.engsoftwaremodulo2.model.Contrato;
import com.api.engsoftwaremodulo2.model.Imovel;
import com.api.engsoftwaremodulo2.model.Inquilino;
import com.api.engsoftwaremodulo2.repository.ContratoRepository;
import com.api.engsoftwaremodulo2.repository.ImovelRepository;
import com.api.engsoftwaremodulo2.repository.InquilinoRepository;
import com.api.engsoftwaremodulo2.service.ContratoService;

public class ContratoServiceImpl implements ContratoService{

	@Autowired
	private ContratoRepository contratoRepository;
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired InquilinoRepository inquilinoRepository;
	
	@Override
	public List<Contrato> obterTodos() {
		
		return this.contratoRepository.findAll();
	}

	@Override
	public Contrato obterPorCodigo(String codigo) {
		return this.contratoRepository.findById(codigo).orElseThrow(() -> new ObjectNotFoundException("Contrato não Existe"));
	}

	@Override
	public Contrato criar(Contrato contrato) {
		
		if(contrato.getImovel() != null && contrato.getInquilino() != null)
		{
			Imovel imovel = this.imovelRepository.findById(contrato.getImovel().getId())
					.orElseThrow(() -> new ObjectNotFoundException("Imóvel não Existe"));
			
			Inquilino inquilino = this.inquilinoRepository.findById(contrato.getInquilino().getId())
					.orElseThrow(() -> new ObjectNotFoundException("Inquilino não Existe"));
			
			contrato.setImovel(imovel);
			contrato.setInquilino(inquilino);
		}
		
		return this.contratoRepository.save(contrato);
	}

	@Override
	public void deletar(String codigo) {
		obterPorCodigo(codigo);
		this.contratoRepository.deleteById(codigo);
		
	}

	@Override
	public Contrato atualizar(Contrato contrato) {
		obterPorCodigo(contrato.getId());
		return this.contratoRepository.save(contrato);
	}

}
