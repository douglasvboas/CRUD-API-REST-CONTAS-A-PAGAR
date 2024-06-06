package com.usercase.contas.domain.service;

import com.usercase.contas.domain.model.Conta;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class CsvImportService {

    private final ContaService contaService;

    public CsvImportService(ContaService contaService) {
        this.contaService = contaService;
    }

    public void importCsv(MultipartFile file) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Conta> contas = new ArrayList<>();

            for (CSVRecord csvRecord : csvParser) {
                Conta conta = new Conta();
                conta.setDataVencimento(LocalDate.parse(csvRecord.get("data_vencimento")));
                conta.setDataPagamento(LocalDate.parse(csvRecord.get("data_pagamento")));
                conta.setValor(new BigDecimal(csvRecord.get("valor")));
                conta.setDescricao(csvRecord.get("descricao"));
                conta.setSituacao(csvRecord.get("situacao"));
                contas.add(conta);
            }

            contaService.saveAll(contas);
        }
    }
}
