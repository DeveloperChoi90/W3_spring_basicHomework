package com.sparta.personprac.controller;

import com.sparta.personprac.domain.Person;
import com.sparta.personprac.domain.PersonRepository;
import com.sparta.personprac.domain.PersonRequestDto;
import com.sparta.personprac.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

        private final PersonRepository personRepository;

        private final PersonService personService;

        @PostMapping("/api/myinfo")
        public Person createPerson(@RequestBody PersonRequestDto requestDto){

                Person person = new Person(requestDto);

                // JPA를 이용하여 DB에 저장, 그 결과를 반환
                return personRepository.save(person);
        }

        @GetMapping("/api/myinfo")
        public List<Person> getPerson() {
                return personRepository.findAll();
        }

        @PutMapping("/api/myinfo/{id}")
        public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto){
                return personService.update(id, requestDto);
        }

        @DeleteMapping("/api/myinfo/{id}")
        public Long deletePerson(@PathVariable Long id){
                personRepository.deleteById(id);
                return id;
        }
}