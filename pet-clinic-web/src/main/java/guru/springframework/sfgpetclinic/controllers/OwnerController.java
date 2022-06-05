package guru.springframework.sfgpetclinic.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class OwnerController {

    @RequestMapping({"/owners","/owners/index","/owners/index.html"})
    public String listOwners(){
        return "owner/index";
    }
}
