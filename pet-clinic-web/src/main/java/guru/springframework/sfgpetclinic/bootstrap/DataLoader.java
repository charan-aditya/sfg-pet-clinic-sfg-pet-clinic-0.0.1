package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


        private final OwnerService ownerService;
        private final VetService vetService;
        private final PetTypeService petTypeService;
        private final SpecialityService specialityService;

    public
        DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService)
        {
            this.ownerService = ownerService;
            this.vetService = vetService;
            this.petTypeService = petTypeService;
            this.specialityService = specialityService;
        }

        @Override
        public void run (String...args) throws Exception {

        int count=petTypeService.findAll().size();
        if( count==0) {
            loadData();
        }
        }
            private void loadData() {
            PetType dog = new PetType();
            dog.setName("Dog");
            PetType savedDogType = petTypeService.save(dog);


            Owner owner1 = new Owner();
            owner1.setFirstName("ram");
            owner1.setLastName("bheem");
            owner1.setAddress("123 stella");
            owner1.setCity("Miami");
            owner1.setTelephone("87876543");
            ownerService.save(owner1);

            Owner owner2 = new Owner();
            owner2.setFirstName("ram A");
            owner2.setLastName("bheem B");
            owner2.setAddress("12 stella");
            owner2.setCity("Miam");
            owner2.setTelephone("87877543");

            ownerService.save(owner2);

            Pet mike = new Pet();
            mike.setPetType(savedDogType);
            mike.setOwner(owner1);
            mike.setName("raghu");
            mike.setBirthDate(LocalDate.now());
            owner1.getPets().add(mike);

            Speciality radiology = new Speciality();
            radiology.setDescription("radiology");
            Speciality SavedRadiology = specialityService.save(radiology);


            Speciality surgery = new Speciality();
            radiology.setDescription("surgery");
            Speciality SavedSurgery = specialityService.save(surgery);

            Speciality dentistry = new Speciality();
            radiology.setDescription("dentistry");
            Speciality SavedDentistry = specialityService.save(dentistry);

            Vet vet1 = new Vet();
            vet1.setFirstName("veer");
            vet1.setLastName("shoor");
            vet1.getSpecialities().add(SavedRadiology);

            vetService.save(vet1);

            Vet vet2 = new Vet();
            vet2.setFirstName("veer");
            vet2.setLastName("shoor");
            vet1.getSpecialities().add(SavedDentistry);
            vetService.save(vet2);
        }
    }

