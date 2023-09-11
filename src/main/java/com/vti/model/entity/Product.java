package com.vti.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "price")//Gía
    private int price;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    // Trạng thái sản phẩm
    private ProductStatus status;

    @Column(name = "shipping_unit", nullable = false)
    @Enumerated(EnumType.STRING)
    // Loại Đơn vị vận chuyển
    private ShippingUnit shippingUnit;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    // Loại sản phẩm
    private ProductType type;
    // Tham chiếu đến productId
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product",fetch = FetchType.LAZY)
//    @JsonManagedReference
    List<Order> orders;

}
