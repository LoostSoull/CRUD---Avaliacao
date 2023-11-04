package com.avaliacao.crud.controllers;

import com.avaliacao.crud.model.ContatoModel;
import com.avaliacao.crud.model.PessoaModel;
import com.avaliacao.crud.repositories.ContatoRepository;
import com.avaliacao.crud.repositories.PessoasRepository;
import com.avaliacao.crud.services.ContatoService;
import com.avaliacao.crud.services.PessoaService;
import com.avaliacao.crud.services.interfaces.ContatoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pessoas")
public class PessoaController {


    PessoasRepository pessoasRepository;

    private ContatoRepository contatoRepository;

    private ContatoService contatoService;


    @Autowired
    public PessoaController(ContatoRepository contatoRepository ,PessoasRepository pessoasRepository,ContatoService contatoService){
        this.pessoasRepository = pessoasRepository;

        this.contatoRepository = contatoRepository;

        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<PessoaModel> savePessoa(@RequestBody PessoaModel pessoaModel){

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoasRepository.save(pessoaModel));
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> getAllPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoasRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPessoaId(@PathVariable(value="id") Long id){
        Optional<PessoaModel> pessoaObject = pessoasRepository.findById(id);
        if(pessoaObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pessoa nao encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaObject.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePessoa(@PathVariable(value="id") Long id , @RequestBody PessoaModel pessoaModel){
        Optional<PessoaModel> pessoaObject = pessoasRepository.findById(id);
        if(pessoaObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao encontrada");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoasRepository.save(pessoaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable(value="id") Long id){
        Optional<PessoaModel> pessoaObject = pessoasRepository.findById(id);
        if(pessoaObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao encontrada");
        }
        pessoasRepository.delete(pessoaObject.get());
        return ResponseEntity.status(HttpStatus.OK).body("o produto foi deletado");
    }
//coontato
    @PostMapping("/{id}/contatos")
    public ResponseEntity<ContatoModel> saveContato(@PathVariable Long id,@RequestBody ContatoModel contatoModel){

         ContatoModel contatoModels = contatoService.save(contatoModel, id);

       return ResponseEntity.status(HttpStatus.CREATED).body(contatoRepository.save(contatoModels));
    }

    //Lista de contatos

    @GetMapping("/{pessoa_id}/contatos")
    public List<ContatoModel> listarContatosDaPessoa(@PathVariable Long pessoa_id) {
        return contatoRepository.findAllByPessoaId(pessoa_id);
    }

}
