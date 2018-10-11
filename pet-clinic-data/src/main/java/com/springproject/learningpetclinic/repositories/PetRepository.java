package com.springproject.learningpetclinic.repositories;

import com.springproject.learningpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
