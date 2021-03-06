package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
   Owner findById(Long Id);
   Owner save(Owner owner);
   Set<Owner> findall();


}
