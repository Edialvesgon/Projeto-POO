package com.fag.domain.repositories;

import com.fag.domain.dto.BankslipDTO;

public interface IBassRepository {
    public abstract String consultarBoleto(String linhaDigitada) throws Exception;
    public abstract String gerarQRCode(Double dadosPix) throws Exception;
    public abstract String pagarBoleto(BankslipDTO dadosBoletoConsultado) throws Exception;
}