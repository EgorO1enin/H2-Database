package com.example.Lesson2.person;

import com.example.Lesson2.Validators.CapitalLetter;
import com.example.Lesson2.adress.Adress;
import com.example.Lesson2.controller.Controller;
import com.example.Lesson2.products.Products;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CapitalLetter //Собственный
    @NotNull(groups = Controller.class) //Вопрос по реализации
    @NotBlank(message = "Требуется указать имя")
    @Length(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    @Pattern(regexp = "[a-zA-Z0-9_]+")
    String name;


    @Pattern(regexp = "^(Male|Female)$", message = "Gender must be 'Male' or 'Female'")
    private String gender;

    @NotBlank(message = "Password is required")
    @Length(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    private Long money;


    @OneToMany
    private List<Products> products = new ArrayList<>();

    @OneToOne
    private Adress adress;



    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }


    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Products> getProducts() {
        return products;
    }


    // getters and setters omitted for brevity
}