package com.example.Lesson2.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Тестовые контроллеры", description="Для тестирования")
@RestController
public class TestController {
    @GetMapping("/test1")
    public String test1(){
        return "Пользователь добавлен";
    }
    @PutMapping("/test2")
    public String test2(){
        return "Пользователь добавлен";
    }
    @PostMapping ("/test3")
    public String test3(){
        return "Пользователь добавлен";
    }
}