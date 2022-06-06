package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.VetService;
import guru.springframework.sfgpetclinic.service.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.service.map.PetServiceMap;
import guru.springframework.sfgpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;

    private final VetService vetService;
    public DataLoader(OwnerService ownerService,VetService vetService) {
     this.ownerService=ownerService;
     this.vetService=vetService;
    }

    @Override
    public void run(String... args) throws Exception {


        Owner owner1=new Owner();
        owner1.setFirstName("ram");
        owner1.setLastName("bheem");
        owner1.setId(2L);
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("ram A");
        owner2.setLastName("bheem B");
        owner2.setId(3L);
        ownerService.save(owner2);

        Vet vet1=new Vet();
        vet1.setFirstName("veer");
        vet1.setLastName("shoor");
        vet1.setId(2L);
        vetService.save(vet1);


        Vet vet2=new Vet();
        vet2.setFirstName("veer");
        vet2.setLastName("shoor");
        vet2.setId(2L);
        vetService.save(vet2);
    }
}
