package com.fag.infra.testdb;

import java.util.ArrayList;
import java.util.List;

import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserRepository;

public class UserTestDb implements IUserRepository{

    private List <UserAccountDTO> users = new ArrayList<>();

    @Override
    public UserAccountDTO createUser(UserAccountDTO dto) {  


        users.add(dto);
        return dto;
    }

    @Override
    public UserAccountDTO findUserBy(String document) {
        
        for (UserAccountDTO user : users) {
            if (user.getDocument().equals(document)) {
                System.out.println("teste");
                return user;
               
            }
        }
        return null;
    }
}
