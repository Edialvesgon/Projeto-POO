package com.fag;

import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterFace;
import com.fag.infra.celcoin.CelcoinBassRepositorory;
import com.fag.infra.console.ConsoleUserInterface;
import com.fag.infra.pg.PgSupabase;
import com.fag.infra.pg.PostgresConnection;
import com.fag.infra.swing.SwingUserInterface;
import com.fag.infra.testdb.UserTestDb;
import com.fag.services.BankingApp;

public class Main {
    public static void main(String[] args) throws Exception {
        SwingUserInterface swingUserInterface = new SwingUserInterface();
        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface();
        CelcoinBassRepositorory celcoinBassRepositorory = new CelcoinBassRepositorory();
        UserTestDb userTestDb = new UserTestDb();
        PgSupabase pg = new PgSupabase();
        

        BankingApp bankingApp = new BankingApp(consoleUserInterface, pg, celcoinBassRepositorory);
        
        while (true) {
            
            Integer escolha = bankingApp.apresentarMeuIniccial();
            
            switch (escolha) {
                case 1:
                LoginDTO loginDTO = bankingApp.geLoginDTO();
                UserAccountDTO user = bankingApp.findUser(loginDTO);
                if(user !=  null){
                    bankingApp.login(user);
                }
                break;
                case 2:
                UserAccountDTO userAccountDTO = bankingApp.gUserAccountDTO();
                
                System.out.println(userAccountDTO.toString());
                
                bankingApp.createUser(userAccountDTO);
                
                bankingApp.login(userAccountDTO);
                break;
                case 3:
                bankingApp.exirMensagem();
                return;
                
                default:
                break;
            }
        }
        
        }
        
    }                            