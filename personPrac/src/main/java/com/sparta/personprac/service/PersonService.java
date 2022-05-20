package com.sparta.personprac.service;

import com.sparta.personprac.domain.Person;
import com.sparta.personprac.domain.PersonRepository;
import com.sparta.personprac.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id, PersonRequestDto requestDto){
        Person person = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        person.update(requestDto);
        return person.getId();
    }
}
