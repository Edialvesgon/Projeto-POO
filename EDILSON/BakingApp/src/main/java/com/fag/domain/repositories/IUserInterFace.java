package com.fag.domain.repositories;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;

public interface IUserInterFace {
    public abstract Integer showInitialScreenMenu();
    public abstract LoginDTO getLoginData();
    public abstract UserAccountDTO getUserAccountDTO();
    public abstract Integer showHomeMenu(String userName);
    public abstract void showErrorMenssagem(String msg);
    public abstract void showExitMessage();
    public abstract String getBarcode();
    public abstract BankslipDTO getPaymentBankslipInfo();
    public abstract void showBankslipInfo(String data);
    public abstract Double getPixData();
    public abstract void showPixData(String data);

}
