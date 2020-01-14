package com.itea.homeworks.hw3.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private int id;
    private String name;
    private String status;
}
