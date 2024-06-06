package com.usercase.contas.domain.repository;

import com.usercase.contas.domain.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findByDataVencimentoBetweenAndDescricaoContaining(LocalDate startDate, LocalDate endDate, String descricao);
}
