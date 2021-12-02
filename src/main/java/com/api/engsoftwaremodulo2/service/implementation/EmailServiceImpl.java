package com.api.engsoftwaremodulo2.service.implementation;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.engsoftwaremodulo2.model.Contrato;
import com.api.engsoftwaremodulo2.repository.ContratoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailServiceImpl {
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	public List<Contrato> contratosPendentes()
	{
		ArrayList<Contrato> contratosPendentes = new ArrayList<Contrato>();
		for(Contrato contrato : contratoRepository.findAll())
		{
			if(contrato.isPendente() == true)
			{
				contratosPendentes.add(contrato);
			}
		}
		
		return contratosPendentes;
	}
	
}
