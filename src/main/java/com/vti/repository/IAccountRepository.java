package com.vti.repository;

import com.vti.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);


}
