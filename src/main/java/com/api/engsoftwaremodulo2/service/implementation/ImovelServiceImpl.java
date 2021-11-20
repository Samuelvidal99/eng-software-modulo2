package com.api.engsoftwaremodulo2.service.implementation;

import com.api.engsoftwaremodulo2.exception.AlreadyExistsInDatabaseException;
import com.api.engsoftwaremodulo2.exception.ObjectNotFoundException;
import com.api.engsoftwaremodulo2.model.Imovel;
import com.api.engsoftwaremodulo2.repository.ImovelRepository;
import com.api.engsoftwaremodulo2.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelServiceImpl implements ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Override
    public Imovel criar(Imovel imovel) {
        Example<Imovel> imovelExample = Example.of(imovel, ExampleMatcher.matchingAll().withIgnorePaths("id"));
        boolean exists = this.imovelRepository.exists(imovelExample);
        if (exists)
            throw new AlreadyExistsInDatabaseException("Imóvel já existe no banco");

        return imovelRepository.save(imovel);
    }

    @Override
    public List<Imovel> obterTodos() {
        return this.imovelRepository.findAll();
    }

    @Override
    public Imovel obterPorId(String id) {
        return this.imovelRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Imóvel não existe no banco"));
    }

    @Override
    public void deletar(String id) {
        if (this.imovelRepository.existsById(id)) this.imovelRepository.deleteById(id);
        else throw new ObjectNotFoundException("Imóvel não existe no banco, não é possível deletar");
    }

    @Override
    public Imovel atualizar(Imovel imovel) {
        if (this.imovelRepository.existsById(imovel.getId())) return this.imovelRepository.save(imovel);
        else throw new ObjectNotFoundException("Imóvel não existe no banco, não é possível atualizar entidade");
    }
}
