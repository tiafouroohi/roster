package com.tia.roster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tia.roster.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact,  Long> {

}
