package com.mypc.program.personaApi.repository;

import com.mypc.program.personaApi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
