package com.springproject.learningpetclinic.repositories;

import com.springproject.learningpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
