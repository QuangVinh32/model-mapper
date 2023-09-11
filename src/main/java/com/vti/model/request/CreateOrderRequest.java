package com.vti.model.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
public class CreateOrderRequest {

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date createDate;
    // Lấy theo định danh department + Id chữ cái đầu viết hoa
    private int accountId;

//    @ProductIdExists()
    private int productId;

    private int quantity;
}
