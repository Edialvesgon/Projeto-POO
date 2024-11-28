package com.fag.infra.swing;

import javax.swing.JOptionPane;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterFace;


public class SwingUserInterface implements IUserInterFace {


        @Override
    public Integer showInitialScreenMenu() {
        String menu = "----------BANCO BALA--------\n"
                .concat("[1] Login\n")
                .concat("[2] Cadastro\n")
                .concat("[3] Sair");

        String escolha = JOptionPane.showInputDialog(
                null,
                menu,
                "🏦Menu Inicial do Banco Bala",
                JOptionPane.INFORMATION_MESSAGE);

        return Integer.parseInt(escolha);
    }

    @Override
    public LoginDTO getLoginData() {
        LoginDTO data = new LoginDTO();

        String document = JOptionPane.showInputDialog(null,
                "Informe seu documento",
                "Informe os dados",
                0);

        String password = JOptionPane.showInputDialog(null,
                "Informe sua senha",
                "Informe os dados",
                0);

        data.setDocument(document);
        data.setPassaword(password);

        return data;
    }

    

    @Override
    public UserAccountDTO getUserAccountDTO() {
        UserAccountDTO userAccountDTO = new UserAccountDTO();
        String document = JOptionPane.showInputDialog(null, "Insira o doumento", "Insira o documento", JOptionPane.DEFAULT_OPTION);
        userAccountDTO.setDocument(document);

        String password = JOptionPane.showInputDialog(null, "Insira a senha", "Insira a senha", JOptionPane.DEFAULT_OPTION);
        userAccountDTO.setDocument(password);

        String name = JOptionPane.showInputDialog(null, "Insira o nome", "Insira o nome", JOptionPane.DEFAULT_OPTION);
        userAccountDTO.setDocument(name);

        String email = JOptionPane.showInputDialog(null, "Insira o e-mail", "Insira o email", JOptionPane.DEFAULT_OPTION);
        userAccountDTO.setDocument(email);

        return userAccountDTO;
    }

@Override
public Integer showHomeMenu(String userName) {
        String menu = "----------Ben vindo "+userName+"--------\n"
                .concat("[1] Consulta Boleto\n")
                .concat("[2] Pagamento boleto\n")
                .concat("[3] GErar qrcode do pix")
                .concat("[4] logout");

        String escolha = JOptionPane.showInputDialog(
                null,
                menu,
                "🏦menu do banco",
                JOptionPane.INFORMATION_MESSAGE);

        return Integer.parseInt(escolha);
}

@Override
public void showErrorMenssagem(String msg) {
        JOptionPane.showMessageDialog(null, "ERRO", msg, JOptionPane.ERROR_MESSAGE);
}

@Override
public void showExitMessage() {
        JOptionPane.showMessageDialog(null, "TCHAU", "TCHAU", JOptionPane.CLOSED_OPTION);
}
    @Override
    public String getBarcode() {
        String barcode = JOptionPane.showInputDialog(
                null,
                "Insira o código de barras a ser consultado",
                "Código de barras",
                JOptionPane.INFORMATION_MESSAGE);

        return barcode;
    }

    @Override
    public BankslipDTO getPaymentBankslipInfo() {
        BankslipDTO bankslipDTO = new BankslipDTO();

        String barcode = JOptionPane.showInputDialog(
                null,
                "Insira o código de barras a ser pago",
                "Código de barras",
                JOptionPane.INFORMATION_MESSAGE);
        String transactionId = JOptionPane.showInputDialog(
                null,
                "Insira o identificador de pagamento",
                "Identificador",
                JOptionPane.INFORMATION_MESSAGE);

        bankslipDTO.setBarcode(barcode);
        bankslipDTO.setTransactionId(transactionId);

        return bankslipDTO;
    }

    @Override
    public void showBankslipInfo(String data) {
        JOptionPane.showMessageDialog(
                null,
                data,
                "Dados boleto",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    @Override
    public Double getPixData() {
        String amount = JOptionPane.showInputDialog(
                null,
                "Insira o valor do PIX",
                "Valor transação",
                JOptionPane.INFORMATION_MESSAGE);

        return Double.parseDouble(amount);
    }

@Override
public void showPixData(String data) {
        JOptionPane.showMessageDialog(
                null,
                data,
                "Dados PIX",
                JOptionPane.INFORMATION_MESSAGE);
}


}