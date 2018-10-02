package com.springproject.learningpetclinic.bootstrap;

import com.springproject.learningpetclinic.model.Owner;
import com.springproject.learningpetclinic.model.Pet;
import com.springproject.learningpetclinic.model.PetType;
import com.springproject.learningpetclinic.model.Vet;
import com.springproject.learningpetclinic.services.OwnerService;
import com.springproject.learningpetclinic.services.PetTypeService;
import com.springproject.learningpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michele");
        owner1.setLastName("Abar");
        owner1.setAddress("123 Rkgi");
        owner1.setCity("Kyiv");
        owner1.setTelephone("24679979");

        Pet michelesPet = new Pet();
        michelesPet.setPetType(savedDogPetType);
        michelesPet.setOwner(owner1);
        michelesPet.setBirthDate(LocalDate.now());
        michelesPet.setName("Murzik");
        owner1.getPets().add(michelesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Francois");
        owner2.setLastName("Manabie");
        owner2.setAddress("123 Rkgi");
        owner2.setCity("Kyiv");
        owner2.setTelephone("24679979");

        Pet francoisCat = new Pet();
        francoisCat.setName("Bublik");
        francoisCat.setOwner(owner2);
        francoisCat.setBirthDate(LocalDate.now());
        francoisCat.setPetType(savedCatPetType);
        owner2.getPets().add(francoisCat);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Adam");
        vet1.setLastName("Szintzel");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Brit");
        vet2.setLastName("Tree");

        vetService.save(vet2);

        }

    }



