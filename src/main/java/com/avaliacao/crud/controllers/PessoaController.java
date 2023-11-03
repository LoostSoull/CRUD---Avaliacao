package com.avaliacao.crud.controllers;

import com.avaliacao.crud.repositories.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @Autowired
    PessoasRepository pessoasRepository;


}
