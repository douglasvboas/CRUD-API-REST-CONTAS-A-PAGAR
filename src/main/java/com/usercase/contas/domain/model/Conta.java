package com.usercase.contas.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal valor;
    private String descricao;
    private String situacao;

    public void setSituacao(String situacao) {
    }

    public boolean getDataPagamento() {
        return false;
    }

    public <R> R getValor() {
        return null;
    }

    public void setDataVencimento(LocalDate parse) {
    }

    public void setDataPagamento(LocalDate parse) {
    }

    public void setValor(BigDecimal bigDecimal) {
    }

    public void setDescricao(String datum) {
    }

    public String getDescricao() {
        return null;
    }

    // Getters and Setters
}

