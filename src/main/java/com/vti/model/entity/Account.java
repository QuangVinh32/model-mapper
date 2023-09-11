package com.vti.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number", length = 12, nullable = false)
    private String phoneNumber;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "facebook", length = 100)
    private String facebook;

    @Column(name = "information", length = 500)
    private String information;
    // Tham chiếu đến account
//    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account",fetch = FetchType.LAZY)
    private List<Order> orders;

}
