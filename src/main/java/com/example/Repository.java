package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Message,Integer> {
}
