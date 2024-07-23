package com.example.Lesson2.person;

import java.io.Serializable;



public class PersonRequestModel implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}