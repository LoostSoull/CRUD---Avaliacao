package com.avaliacao.crud.model;

import jakarta.persistence.*;

@Entity
@Table(name="contatos")
public class ContatoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int tipoContato;

    @Column(nullable = false)
    private String contato;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private PessoaModel pessoa;


    private ContatoModel(){}

    public ContatoModel(Long id, int tipoContato, String contato, PessoaModel pessoa) {
        this.id = id;
        this.tipoContato = tipoContato;
        this.contato = contato;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(int tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public PessoaModel getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModel pessoa) {
        this.pessoa = pessoa;
    }
}
