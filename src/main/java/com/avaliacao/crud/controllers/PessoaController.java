package com.avaliacao.crud.controllers;

import com.avaliacao.crud.dtos.PessoaRecordDto;
import com.avaliacao.crud.model.ContatoModel;
import com.avaliacao.crud.model.PessoaModel;
import com.avaliacao.crud.repositories.PessoasRepository;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class PessoaController {

    @Autowired
    PessoasRepository pessoasRepository;


    @PostMapping("/pessoas")
    public ResponseEntity<PessoaModel> savePessoa(@RequestBody @Valid PessoaRecordDto pessoaRecordDto){
        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaRecordDto,pessoaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoasRepository.save(pessoaModel));
    }

    @GetMapping("/pessoas")
    public ResponseEntity<List<PessoaModel>> getAllPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoasRepository.findAll());
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<Object> getPessoaId(@PathVariable(value="id") Long id){
        Optional<PessoaModel> pessoaObject = pessoasRepository.findById(id);
        if(pessoaObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pessoa nao encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaObject.get());
    }

    @PutMapping("/pessoas/{id}")
    public ResponseEntity<Object> updatePessoa(@PathVariable(value="id") Long id , @RequestBody @Valid PessoaRecordDto pessoaRecordDto){
        Optional<PessoaModel> pessoaObject = pessoasRepository.findById(id);
        if(pessoaObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao encontrada");
        }
        var pessoaModel = pessoaObject.get();
        BeanUtils.copyProperties(pessoaRecordDto,pessoaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoasRepository.save(pessoaModel));
    }

    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable(value="id") Long id){
        Optional<PessoaModel> pessoaObject = pessoasRepository.findById(id);
        if(pessoaObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao encontrada");
        }
        pessoasRepository.delete(pessoaObject.get());
        return ResponseEntity.status(HttpStatus.OK).body("o produto foi deletado");
    }
}
