package com.avaliacao.crud.dtos;

import javax.validation.constraints.NotNull;

public record ContatoRecordDto( @NotNull int tipoContato, @NotNull int contato) {
}
