package com.usercase.contas.domain.service.impl;

import com.usercase.contas.domain.model.Conta;
import com.usercase.contas.domain.repository.ContaRepository;
import com.usercase.contas.domain.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }

    @Override
    public Conta update(Conta conta) {
        return contaRepository.save(conta);
    }

    @Override
    public Optional<Conta> findById(Long id) {
        return contaRepository.findById(id);
    }

    @Override
    public Page<Conta> findAll(Pageable pageable) {
        return contaRepository.findAll(pageable);
    }

    @Override
    public List<Conta> findByDataVencimentoAndDescricao(LocalDate dataVencimento, String descricao) {
        // Implement custom query method in repository if needed
        return null;
    }

    @Override
    public void delete(Long id) {
        contaRepository.deleteById(id);
    }

    @Override
    public BigDecimal totalValorPagoPorPeriodo(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public void saveAll(List<Conta> contas) {

        for (Conta conta : contas) {
            System.out.println("Salvando conta: " + conta);
        }

    }
}