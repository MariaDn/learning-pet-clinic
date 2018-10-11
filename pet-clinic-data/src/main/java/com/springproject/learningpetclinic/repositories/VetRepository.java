package com.springproject.learningpetclinic.repositories;

import com.springproject.learningpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
