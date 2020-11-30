package com.tia.roster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tia.roster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
