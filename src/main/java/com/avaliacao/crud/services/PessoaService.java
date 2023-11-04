package com.avaliacao.crud.services;

import com.avaliacao.crud.model.PessoaModel;
import com.avaliacao.crud.repositories.PessoasRepository;
import com.avaliacao.crud.services.interfaces.PessoaServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements PessoaServiceInterface {

    private PessoasRepository pessoasRepository;
    @Override
    public PessoaModel save(PessoaModel pessoaModel) {
        return pessoasRepository.save(pessoaModel);
    }

    @Override
    public Optional<PessoaModel> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PessoaModel> getAll() {
        return null;
    }

    @Override
    public PessoaModel update(PessoaModel pessoaModel) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
