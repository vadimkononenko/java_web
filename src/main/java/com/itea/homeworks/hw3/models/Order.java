package com.itea.homeworks.hw3.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String status;
}
