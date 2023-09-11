package com.vti.model.request;

import com.vti.model.entity.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class CreateAccountRequest {

    @NotBlank(message = "Tên không được để trống")
    private String username;

    @NotBlank(message = "Password không được để trống")
    @Size(min = 6, max = 20, message = "password phải có 6-20 ký tự")
    private String password;

    private Date dateOfBirth;

    private String address;
    @NotBlank(message = "Tên không được để trống")
    private String fullName;

    private String phoneNumber;

    private String email;

    private String facebook;

    private String information;
    private Role role;
}