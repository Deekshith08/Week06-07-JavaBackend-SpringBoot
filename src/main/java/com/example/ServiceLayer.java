package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {
    @Autowired
    Repository repo;

    public Message greet(){
        Message m = new Message("Hello World");
        repo.save(m);
        return m;
    }

    public List<Message> getAll(){
        return repo.findAll();
    }

    public Message getById(int id){
        return repo.findById(id).orElse(null);
    }

    public Message greetWithName(User user){
        Message m = new Message("Hello " + user.getFirstName() + " " + user.getLastName());
        repo.save(m);
        return m;
    }

    public Message editMessage(int id,Message msg){
        return repo.findById(id).map(m ->{
         m.setGreeting(msg.getGreeting());
        return repo.save(m);
    }).orElse(null);
    }

    public String clearAll(){
        repo.deleteAll();
        return "All greeting are deleted";
    }

    public String deleteById(int id){
        repo.deleteById(id);
        return "Greeting with id " + id + " deleted.";
    }
}
