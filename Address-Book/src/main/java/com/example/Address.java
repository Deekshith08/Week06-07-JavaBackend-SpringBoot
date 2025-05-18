package com.example;

import lombok.Data;


@Data
public class Address {
    private static int counter = 1;
    private int id;
    private String fullName;
    private long phoneNo;
    private String address;

    public Address(String fullName, long phoneNo, String address) {
        this.id = counter++;
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.address = address;
    }

}
