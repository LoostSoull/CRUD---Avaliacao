package com.avaliacao.crud.controllers;

import com.avaliacao.crud.dtos.ContatoRecordDto;
import com.avaliacao.crud.dtos.PessoaRecordDto;
import com.avaliacao.crud.model.ContatoModel;
import com.avaliacao.crud.model.PessoaModel;
import com.avaliacao.crud.repositories.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContatoController {

    @Autowired
    ContatoRepository contatoRepository;

    @PostMapping("/pessoas/{id}/contatos")
    public ResponseEntity<ContatoModel> saveContato(@RequestBody @Valid ContatoRecordDto contatoRecordDto){
        List<ContatoModel> = contatoModelList<>;
        BeanUtils.copyProperties(contatoRecordDto,contatoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoRepository.save(contatoModel));
    }
}
