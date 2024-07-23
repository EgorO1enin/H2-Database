package com.example.Lesson2.controller;

import com.example.Lesson2.adress.AdressRepository;
import com.example.Lesson2.person.Person;
import com.example.Lesson2.person.PersonRepository;
import com.example.Lesson2.products.Products;
import com.example.Lesson2.products.ProductsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Tag(name = "Работа с пользовыателем", description="Описание")
@RestController
//@Api(description = "Контроллеры для работы с пользователями")
public class Controller {

    //Добавление пользователя
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AdressRepository adressRepository;
    @Autowired
    private ProductsRepository productsRepository;

    //Добавление в базу данных
    @Operation(
            summary = "Добавление person в базу данных",
            description = "Вводится имя, пароль, и адресс проживания"
    )
    @Transactional
    @PostMapping("admin/add/person")
    public String addPerson(@RequestBody Person person){
        adressRepository.save(person.getAdress());
        personRepository.save(person);
        return "Пользователь добавлен";
    }


    @Operation(
            summary = "Добавление список person в базу данных",
            description = "Вводится имя, пароль, и адресс проживания"
    )
    @PostMapping("/admin/add/persons")
    public List<Person> addPersons(@RequestBody @Validated List<Person> persons){
        return personRepository.saveAll(persons);
    }


    //Получение пользователя по айди
    @Operation(
            summary = "Получение пользователя по айди",
            description = "Вводится айди пользователя"
    )
    @GetMapping("/admin/get")
    public Person getById(@RequestParam Long id ){
        Optional<Person> person = personRepository.findById(id);
        return person.get();
    }

    //Получение всех пользователей
    @Operation(
            summary = "Получение всех добавленных пользователей",
            description = "Все пользователи и их данные"
    )
    @GetMapping("/admin/get/all")
    public List<Person> getAll(){
        return personRepository.findAll();
    }

    //Получение пользовател по полу
    @Operation(
            summary = "Получение всех пользователей по гендеру",
            description = "Вводится Male/Female"
    )
    @GetMapping("/admin/get/user/by/gender")
    public List<Person> getByGender(@RequestParam @Validated String gender){
        //Optional<Person> person = personRepository.fi
        return personRepository.findAllByGender(gender);
    }

    //Получение всех users мужского пола
    @Operation(
            summary = "Получение всех пользователей мужского пола"
    )
    @GetMapping("/admin/male/users")
    public List<Person> getAllMale(){
        return personRepository.findAllByGender("Male");
    }

    //Удаление пользователя по айди
    @Operation(
            summary = "Удаление пользователя из базы данных по айди",
            description = "Вводится айди пользователя которого нужно удалить"
    )
    @DeleteMapping("/admin/delete/user")
    public void deleteUserById(@RequestParam Long id){
        personRepository.deleteById(id);
    }

    //Удаление всех пользователей
    @Operation(
            summary = "Удаление всех пользователей из базы данных"
    )
    @DeleteMapping("/admin/delete/all")
    public String deleteAllUsers(){
        personRepository.deleteAll();
        adressRepository.deleteAll();
        return "Пользователи удалены!";
    }

    //Изменение пользователя по айди
    @Operation(
            summary = "Изменение пользователя по айди",
            description = "Вводится айди пользователя и новый user"
    )
    @PutMapping("/admin/change/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody @Validated Person person){
        person.setId(id);
        personRepository.save(person);
    }

    //Поиск пользователя по имени
    @Operation(
            summary = "Поиск пользователя по имени",
            description = "Вводится имя пользователя которого надо найти"
    )
    @GetMapping("/admin/user/find/{name}")
    public List<Person> findPersonsByName(@PathVariable @Validated String name){
        return personRepository.findAllByName(name);
    }

    //Связывание двух микросервисов
    @Autowired
    private RestTemplate restTemplate;
    @Operation(
            summary = "Получение продукта из другого сервиса и добавление его в корзину пользователя",
            description = "Воводится айди пользователя и айди товара"
    )
    @PostMapping ("/admin/put/poduct/to/user/{userId}/{productId}")
    public String addProductToCart(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId){
        Person person = this.personRepository.getReferenceById(userId);
        Products products = this.restTemplate.getForObject("http://localhost:8082/get/"+productId, Products.class); // получаем продукт из другого сервиса
        this.productsRepository.save(products);
        person.getProducts().add(products);
        this.personRepository.save(person);
        return "Товар добавлен в корзину!";
    }

    @Operation(
            summary = "Возвращает корзину пользователя по его айди",
            description = "Вводится айди пользователя"
    )
    @GetMapping("/admin/get/cart/user/{userId}")
    public List<Products> getAllProductsFromUser(@PathVariable("userId") Long personId){
        Person person = personRepository.getReferenceById(personId);
        List<Products> products = person.getProducts();
        return products;
    }

    @Operation(
            summary = "Пополнение баланса пользователя",
            description = "Вводится количество денег и айди пользователя"
    )
    @PostMapping("/admin/put/money")
    public String putMoney (@RequestParam("money") Long money, @RequestParam("user") Long userId){
        Person person = personRepository.getReferenceById(userId);
        person.setMoney(person.getMoney() + money);
        return "Баланс пополнен на " + money;
    }



}













