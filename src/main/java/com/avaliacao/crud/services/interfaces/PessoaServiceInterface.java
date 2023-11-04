package com.avaliacao.crud.services.interfaces;

import com.avaliacao.crud.model.PessoaModel;

import java.util.List;
import java.util.Optional;

public interface PessoaServiceInterface {
        PessoaModel save(PessoaModel pessoaModel);
        Optional<PessoaModel> getById(Long id);
        List<PessoaModel> getAll();
        PessoaModel update(PessoaModel pessoaModel);
        void delete(Long id);


}
