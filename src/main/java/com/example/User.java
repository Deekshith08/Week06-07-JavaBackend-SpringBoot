package com.example;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class User {
    String firstName;
    String lastName;

}

@Data
@Entity
@Table(name="Greetings")
class Message{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String greeting;

    public Message(String greeting) {
        this.greeting = greeting;
    }

    public Message() {

    }
}