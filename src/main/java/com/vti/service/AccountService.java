package com.vti.service;

import com.vti.model.entity.Account;
import com.vti.model.request.CreateAccountRequest;
import com.vti.repository.IAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IAccountRepository repository;


    @Override
    public Page<Account> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public Account findById(int id) {
        return repository.findById(id).orElse(null);
    }


    @Override
    public Account findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void create(CreateAccountRequest request) {
        Account account = mapper.map(request,Account.class);
        repository.save(account);

    }


    @Override
    public void update(Account account) {
        repository.save(account);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }
}
