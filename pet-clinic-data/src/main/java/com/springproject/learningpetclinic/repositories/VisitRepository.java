package com.springproject.learningpetclinic.repositories;

import com.springproject.learningpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
