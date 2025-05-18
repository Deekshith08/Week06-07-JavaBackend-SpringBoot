package com.example;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Service
public class ServiceLayer {

    List<Address> book = new ArrayList<>();

    public List<Address> findAll(){
        return book;
    }

    public Object findById(int id){
        for(Address ad : book){
            if(ad.getId() == id){
                return ad;
            }
        }
        return "Address with id " + id + " not found";
    }

    public Address create(AddressRequestDTO address){
        Address ad = new Address(address.getFullName(), address.getPhoneNo(), address.getAddress());
        book.add(ad);
        return ad;
    }

    public Object edittById(int id, AddressRequestDTO address){
        for(Address ad: book){
            if(ad.getId() == id){
                ad.setFullName(address.getFullName());
                ad.setAddress(address.getAddress());
                ad.setPhoneNo(address.getPhoneNo());
                return ad;
            }
        }
        return "Address with id " + id + " not found";
    }

    public String deleteById(int id){
        Iterator<Address> it = book.iterator();
        while(it.hasNext()){
            if(it.next().getId() == id){
                it.remove();
                return "Address with id " + id + " deleted";
            }
        }
        return "Address with id " + id + " not found";
    }
}
