package com.example.Lesson2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lesson2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson2Application.class, args);
	}
}
/*
	@Bean
	CommandLineRunner runner(PersonRepository repository){
		return args -> {
			Person person = new Person();
			person.setName("John");

			repository.save(person);
			Person saved = repository.findById(person.getId()).orElseThrow(NoSuchElementException::new);
		};
	}

}*/
/*@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(PersonRepository repository) {
    return args -> {

      Person person = new Person();
      person.setName("John");

      repository.save(person);
      Person saved = repository.findById(person.getId()).orElseThrow(NoSuchElementException::new);
    };
  }
}*/
