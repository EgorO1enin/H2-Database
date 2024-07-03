package com.example.Lesson2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PersonRepository extends JpaRepository<Person, Long> {

}