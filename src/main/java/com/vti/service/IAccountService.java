package com.vti.service;

import com.vti.model.entity.Account;
import com.vti.model.request.CreateAccountRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<Account> findAll(Pageable pageablet);
    Account findById(int id);
    Account findByUsername(String username);
    void create(CreateAccountRequest request);
    void update(Account account);
    void deleteById(int id);

}
