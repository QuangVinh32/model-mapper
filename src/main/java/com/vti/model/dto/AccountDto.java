package com.vti.model.dto;

import com.vti.model.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {
//    private int id;
    private String username;
    private Role role;
    private String fullName;
    private String phoneNumber;
    private String information;
}
