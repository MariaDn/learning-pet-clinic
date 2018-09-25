package com.springproject.learningpetclinic.bootstrap;

import com.springproject.learningpetclinic.model.Owner;
import com.springproject.learningpetclinic.model.Vet;
import com.springproject.learningpetclinic.services.OwnerService;
import com.springproject.learningpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michele");
        owner1.setLastName("Abar");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Francois");
        owner2.setLastName("Manabie");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Adam");
        vet1.setLastName("Szintzel");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Brit");
        vet2.setLastName("Tree");

        vetService.save(vet2);

        }

    }



