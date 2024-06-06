package com.usercase.contas.application.service;

import com.usercase.contas.domain.model.Conta;
import com.usercase.contas.domain.repository.ContaRepository;
import com.usercase.contas.domain.service.ContaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ContaServiceTest {

    @Autowired
    private ContaService contaService;

    @MockBean
    private ContaRepository contaRepository;

    @Test
    public void testSaveConta() {
        Conta conta = new Conta();
        conta.setDescricao("Teste");
        Mockito.when(contaRepository.save(conta)).thenReturn(conta);

        Conta savedConta = contaService.save(conta);
        Assertions.assertEquals("Teste", savedConta.getDescricao());
    }
}
