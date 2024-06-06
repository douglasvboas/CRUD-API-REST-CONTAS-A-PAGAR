package com.usercase.contas.domain.service;

import com.usercase.contas.domain.model.Conta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContaService {
    Conta save(Conta conta);
    Conta update(Conta conta);
    Optional<Conta> findById(Long id);
    Page<Conta> findAll(Pageable pageable);
    List<Conta> findByDataVencimentoAndDescricao(LocalDate dataVencimento, String descricao);
    void delete(Long id);
    BigDecimal totalValorPagoPorPeriodo(LocalDate startDate, LocalDate endDate);

    void saveAll(List<Conta> contas);
}
