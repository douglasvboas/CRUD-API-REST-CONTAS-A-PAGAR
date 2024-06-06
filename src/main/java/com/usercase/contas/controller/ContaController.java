package com.usercase.contas.controller;

import com.usercase.contas.domain.model.Conta;
import com.usercase.contas.domain.service.ContaService;
import com.usercase.contas.domain.service.CsvImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<Conta> createConta(@RequestBody Conta conta) {
        Conta savedConta = contaService.save(conta);
        return ResponseEntity.ok(savedConta);
    }

    @PatchMapping("/{id}/situacao")
    public ResponseEntity<Conta> updateSituacao(@PathVariable Long id, @RequestParam String situacao) {
        Optional<Conta> optionalConta = contaService.findById(id);
        if (optionalConta.isPresent()) {
            Conta conta = optionalConta.get();
            conta.setSituacao(situacao);
            contaService.update(conta);
            return ResponseEntity.ok(conta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Conta>> getContas(Pageable pageable) {
        Page<Conta> contas = contaService.findAll(pageable);
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable Long id) {
        Optional<Conta> conta = contaService.findById(id);
        return conta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> getTotalValorPagoPorPeriodo(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        BigDecimal total = contaService.totalValorPagoPorPeriodo(startDate, endDate);
        return ResponseEntity.ok(total);
    }
    @PostMapping("/import")
    public ResponseEntity<String> importContasCsv(@RequestParam("file") MultipartFile file) {
        try {
            CsvImportService csvImportService = null;
            csvImportService.importCsv(file);
            return ResponseEntity.ok("Importação realizada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro na importação: " + e.getMessage());
        }
    }

}
