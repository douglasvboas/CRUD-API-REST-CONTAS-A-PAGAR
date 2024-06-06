package com.usercase.contas.controller;

        import com.usercase.contas.domain.model.Conta;
        import com.usercase.contas.domain.service.ContaService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.math.BigDecimal;
        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;

@RestController
@RequestMapping("/api/import")
public class ImportController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/csv")
    public void importCsv(@RequestParam("file") MultipartFile file) {
        List<Conta> contas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Conta conta = new Conta();
                conta.setDataVencimento(LocalDate.parse(data[0]));
                conta.setDataPagamento(LocalDate.parse(data[1]));
                conta.setValor(new BigDecimal(data[2]));
                conta.setDescricao(data[3]);
                conta.setSituacao(data[4]);
                contas.add(conta);
            }
            contaService.saveAll(contas);
        } catch (Exception e) {
            // handle exception
        }
    }
}
