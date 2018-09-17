package com.springproject.learningpetclinic.services;

import com.springproject.learningpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
