package com.api.engsoftwaremodulo2.service.implementation;

import com.api.engsoftwaremodulo2.model.Imovel;
import com.api.engsoftwaremodulo2.repository.ImovelRepository;
import com.api.engsoftwaremodulo2.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelServiceImpl implements ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Override
    public Imovel criar(Imovel imovel) {
        return imovelRepository.save(imovel);
    }
}
