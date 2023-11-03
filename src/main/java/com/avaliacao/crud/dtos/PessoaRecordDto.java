package com.avaliacao.crud.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record PessoaRecordDto(@NotNull @NotBlank String nome, @NotBlank String endereco,@NotNull int cep,@NotBlank String cidade,@NotBlank String uf) {
}
