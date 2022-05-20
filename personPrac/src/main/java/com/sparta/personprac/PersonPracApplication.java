package com.sparta.personprac;

import com.sparta.personprac.domain.Person;
import com.sparta.personprac.domain.PersonRepository;
import com.sparta.personprac.domain.PersonRequestDto;
import com.sparta.personprac.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class PersonPracApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonPracApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
        return (args) -> {
            personRepository.save(new Person("손흥민", "축구선수", 30, "영국런던 토트넘"));

            System.out.println("데이터 인쇄");
            List<Person> personList = personRepository.findAll();
            showList(personList);


//			courseRepository.deleteAll();
        };
    }

    private void showList(List<Person> courseList) {
        for (Person p : courseList) {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getJob());
            System.out.println(p.getAge());
            System.out.println(p.getAddress());
        }
    }
}