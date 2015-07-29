package com.yan.onetomany_bi.service;

import org.springframework.data.repository.CrudRepository;

import com.yan.onetomany_bi.model.Person;

public interface PersonService extends CrudRepository<Person, Long> {

}
