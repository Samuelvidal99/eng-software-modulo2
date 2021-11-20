package com.api.engsoftwaremodulo2.service;

import com.api.engsoftwaremodulo2.model.Imovel;

import java.util.List;

public interface ImovelService {

    Imovel criar(Imovel imovel);

    List<Imovel> obterTodos();

    Imovel obterPorId(String id);

    void deletar(String id);

    Imovel atualizar(Imovel imovel);
}