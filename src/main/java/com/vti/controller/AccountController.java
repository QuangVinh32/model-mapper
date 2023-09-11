package com.vti.controller;
import com.vti.model.dto.AccountDto;
import com.vti.model.entity.Account;
import com.vti.model.request.CreateAccountRequest;
import com.vti.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.function.Function;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IAccountService service;

    @GetMapping
    //convention
    public Page<AccountDto> findAll(Pageable pageable){
        Page<Account> page = service.findAll(pageable);
        return page.map(new Function<Account, AccountDto>() {
            @Override
            public AccountDto apply(Account account) {
                return mapper.map(account,AccountDto.class);
            }
        });
    }
    @GetMapping("/{id}")
    public AccountDto findById(@PathVariable("id") int id){
       Account account = service.findById(id);
        return mapper.map(account,AccountDto.class);
    }
    @GetMapping("/name/{username}")
    public Account findByUsername(@PathVariable("username") String username){
        return service.findByUsername(username);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateAccountRequest request){
        service.create(request);
        return ResponseEntity.ok("Thêm thành công");
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Account account) {
        service.update(account);
        return ResponseEntity.ok("Sửa thành công");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
        return ResponseEntity.ok("Xóa thành công");
    }



}

