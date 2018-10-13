package com.springproject.learningpetclinic.bootstrap;

import com.springproject.learningpetclinic.model.*;
import com.springproject.learningpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count==0) { dataLoad();}

        }

    private void dataLoad() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);


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

        Visit catVisit = new Visit();
        catVisit.setPet(francoisCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Kitty flue");

        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Adam");
        vet1.setLastName("Szintzel");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Brit");
        vet2.setLastName("Tree");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);
    }

}



