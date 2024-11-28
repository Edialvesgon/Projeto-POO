package com.fag.services;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IBassRepository;
import com.fag.domain.repositories.IUserInterFace;
import com.fag.domain.repositories.IUserRepository;

public class BankingApp {
    private IUserInterFace iUserInterFace;
    private IUserRepository userDB;
    private IBassRepository iBassRepository;
    private Integer conta = 1;

    public BankingApp(IUserInterFace iUserInterFace, IUserRepository userRepository, IBassRepository iBassRepository){
        this.iUserInterFace = iUserInterFace;
        this.userDB = userRepository;
        this.iBassRepository = iBassRepository;
    }

    public Integer apresentarMeuIniccial(){
        return iUserInterFace.showInitialScreenMenu();
    }
    public LoginDTO geLoginDTO(){
        return iUserInterFace.getLoginData();
    }
    public UserAccountDTO gUserAccountDTO(){
       UserAccountDTO userAccountDTO = iUserInterFace.getUserAccountDTO();

       userAccountDTO.setId(UUID.randomUUID().toString());
       userAccountDTO.setAccountNumber(conta.toString());
       userAccountDTO.setCreatedAt(LocalDateTime.now());

       conta++;

       return userAccountDTO;

    }
    // public Integer showHomemenu(){

    //     return 0;
    // }

    public void exirMensagem(){
        iUserInterFace.showExitMessage();
    }

    public void login(UserAccountDTO user) throws Exception{
        while (true) {
            
            Integer option = iUserInterFace.showHomeMenu(user.getName());
            
            switch (option) {
                case 1:
                String barcode = iUserInterFace.getBarcode();
                
                String response = iBassRepository.consultarBoleto(barcode);
                iUserInterFace.showBankslipInfo(response);
                
                break;
                case 2:
                BankslipDTO bankslipDTO = iUserInterFace.getPaymentBankslipInfo();
                String pay = iBassRepository.pagarBoleto(bankslipDTO);
                iUserInterFace.showBankslipInfo(pay);
                break;
                case 3:
                Double amoun = iUserInterFace.getPixData();
                String top=iBassRepository.gerarQRCode(amoun);
                iUserInterFace.showPixData(top);
                break;
                case 4:
                iUserInterFace.showExitMessage();
                return;
            }
        }
    }
    public UserAccountDTO findUser(LoginDTO loginDTO){
        UserAccountDTO user = userDB.findUserBy(loginDTO.getDocument());

        if(user == null){
            iUserInterFace.showErrorMenssagem("usuário não criado");
            return null;
        }if(!user.getPassword().equals(loginDTO.getPassaword())){
            iUserInterFace.showErrorMenssagem("Credencial invalida!");
            return null;
        }
        return user;
    }
    public UserAccountDTO createUser(UserAccountDTO user){
            return userDB.createUser(user);
    }
}
