package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class GreetingController {
    @Autowired
    ServiceLayer service;

    @PostMapping
    public Message justGreet(){
        return service.greet();
    }

    @PostMapping("/greet")
    public Message greet(@RequestBody User user){
        return service.greetWithName(user);
    }

    @PutMapping("/edit/{id}")
    public Message edit(@PathVariable int id,@RequestBody Message msg){
        return service.editMessage(id,msg);
    }

    @GetMapping("/getAll")
    public List<Message> getAllGreets(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Message getId(@PathVariable int id){
        return service.getById(id);
    }

    @DeleteMapping("/clearAll")
    public String clear(){
        return service.clearAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return service.deleteById(id);
    }
}
