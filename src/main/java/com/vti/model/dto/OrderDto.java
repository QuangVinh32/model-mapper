package com.vti.model.dto;

import com.vti.model.entity.StatusOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDto {
    private Date createDate;
    private int quantity;
    private StatusOrder status;
    private String accountUsername;
    private String productName;
}
