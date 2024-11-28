package com.fag.infra.console;

import java.util.Scanner;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterFace;


public class ConsoleUserInterface implements IUserInterFace{

    private Scanner input = new Scanner(System.in);

    @Override
    public Integer showInitialScreenMenu() {
        System.out.println("----------BANCO--------");
        System.out.println("[1] Login");
        System.out.println("[2] Cadastro");
        System.out.println("[3] Sair");

        Integer option = input.nextInt();

        input.nextLine();
        
        return option;
    }

    @Override
    public LoginDTO getLoginData() {
        LoginDTO data = new LoginDTO();
        input.nextLine();

        System.out.println("Informe seu documento:");
        String document = input.nextLine();

        System.out.println("Informe sua senha:");
        String password = input.nextLine();

        input.nextLine();

        data.setDocument(document);
        data.setPassaword(password);

        return data;
    }


    @Override
    public UserAccountDTO getUserAccountDTO() {
        UserAccountDTO userData = new UserAccountDTO();
        input.nextLine();

        System.out.println("Informe seu documento:");
        String document = input.nextLine();

        System.out.println("informe sua sneha");
        String passaword = input.nextLine();

        System.out.println("Informe seu nome:");
        String name = input.nextLine();

        System.out.println("Informe seu email:");
        String email = input.nextLine();

        input.nextLine();

        userData.setDocument(document);
        userData.setName(name);
        userData.setEmail(email);
        userData.setPassword(passaword);

       return userData;
    }

    @Override
    public Integer showHomeMenu(String userName) {
        System.out.println("----Bem vindo "+ userName+"-----");
        System.out.println("[1] Consulta Boleto");
        System.out.println("[2] Pagamento boleto");
        System.out.println("[3] GErar qrcode do pix");
        System.out.println("[4] logout");

        Integer option = input.nextInt();

        input.nextLine();

        return option;
    }

    @Override
    public void showErrorMenssagem(String msg) {
        System.out.println("Erro:"+ msg);
    }

    @Override
    public void showExitMessage() {
        System.out.println("tchau");
    }

    @Override
    public String getBarcode() {
        System.out.println("Insira o código de barras:");
        String barcode = input.nextLine();

        return barcode;
    }

    @Override
    public BankslipDTO getPaymentBankslipInfo() {
        BankslipDTO bankslipDTO = new BankslipDTO();

        System.out.println("Insira o código de barras:");
        String barcode = input.nextLine();

        System.out.println("Insira o identificador de pagamento:");
        String id = input.nextLine();

        bankslipDTO.setBarcode(barcode);
        bankslipDTO.setTransactionId(id);

        return bankslipDTO;
    }


    @Override
    public Double getPixData() {
        System.out.println("Insira valor do PIX:");
        Double amount = input.nextDouble();

        return amount;
    }

    @Override
    public void showPixData(String data) {
    System.out.println("Dados do PIX: " + data);
    }

    @Override
    public void showBankslipInfo(String data) {
        System.out.println("Dados do boleto: " + data);
    }

    
    
}