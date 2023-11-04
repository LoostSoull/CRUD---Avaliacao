package com.avaliacao.crud.services;

import com.avaliacao.crud.model.ContatoModel;
import com.avaliacao.crud.model.PessoaModel;
import com.avaliacao.crud.repositories.ContatoRepository;
import com.avaliacao.crud.repositories.PessoasRepository;
import com.avaliacao.crud.services.interfaces.ContatoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {


    private  PessoasRepository pessoaRepository;
    private  ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository ,PessoasRepository pessoaRepository ){
        this.contatoRepository = contatoRepository;
        this.pessoaRepository = pessoaRepository;
    }



    public ContatoModel save(ContatoModel contatoModel,Long pessoa_id) {
        Optional<PessoaModel> pessoaModelOptional= pessoaRepository.findById(pessoa_id);
        if(pessoaModelOptional.isPresent()){
            PessoaModel pessoaModel = pessoaModelOptional.get();
            contatoModel.setPessoa(pessoaModel);
            return contatoRepository.save(contatoModel);
        }
        return contatoModel;
    }


    public Optional<ContatoModel> getById(Long id) {
        return contatoRepository.findById(id);
    }


    public List<ContatoModel> getAll() {
        return null;
    }


    public ContatoModel update(ContatoModel contatoModel) {
        return null;
    }


    public void delete(Long id) {

    }
}
