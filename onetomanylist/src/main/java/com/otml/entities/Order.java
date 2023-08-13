package com.otml.entities;

import java.time.LocalDate;

import lombok.Data;
@Data
public class Order {
private int orderNo;
private String customerName;
private String mobileNo;
private String emailId;
private double amount;
private LocalDate orderDate;

}
