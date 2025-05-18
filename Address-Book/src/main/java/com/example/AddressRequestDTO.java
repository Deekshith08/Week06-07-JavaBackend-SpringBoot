package com.example;

import lombok.Data;

@Data
public class AddressRequestDTO {

    private String fullName;
    private long phoneNo;
    private String address;

    public AddressRequestDTO(String fullName, long phoneNo, String address) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.address = address;
    }
}
