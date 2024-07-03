package com.example.Lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {


    @Autowired
    private PersonRepository personRepository;
    @PostMapping("/add")
    public Person saveMethod(@RequestBody Person person){
        return personRepository.save(person);
    }

    @GetMapping("/get")
    public Person getById(@RequestParam Long id ){
       return personRepository.getReferenceById(id);
    }

    @GetMapping("/getAll")
    public List<Person> getAll(){
        return personRepository.findAll();
    }

}
