package com.avaliacao.crud.services.interfaces;

import com.avaliacao.crud.model.ContatoModel;
import com.avaliacao.crud.model.PessoaModel;

import java.util.List;
import java.util.Optional;

public interface ContatoServiceInterface {
    ContatoModel save(ContatoModel contatoModel,Long pessoa_id);
    Optional<ContatoModel> getById(Long id);
    List<ContatoModel> getAll();
    ContatoModel update(ContatoModel contatoModel);
    void delete(Long id);

}