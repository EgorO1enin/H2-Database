package com.example.Lesson2.person;

import com.example.Lesson2.products.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByGender(String gender);
    List<Person> findAllByName(String name);
    List<Products> findAllProductsOfPersonById(Long id);
    Optional<Person> findByName(String username);


}