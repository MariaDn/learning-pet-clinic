package com.springproject.learningpetclinic.repositories;

import com.springproject.learningpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
