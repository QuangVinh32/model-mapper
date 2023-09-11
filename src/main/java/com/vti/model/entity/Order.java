package com.vti.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
//    [Hibernate] alter table `order` add constraint `FK9hu3bitkigl7v59oa0m0a3dae` foreign key (`account_id`) references `account` (`id`)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
//    [Hibernate] alter table `order` add constraint `FKjrpbyemhk1v5khaibajgy2wd7` foreign key (`product_id`) references `product` (`id`)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "quantity")
    // Số lượng
    private int quantity;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusOrder status;
}


