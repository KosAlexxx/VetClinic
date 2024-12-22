package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

public class AplicationRunner {
    private final EntityRegister register = new EntityRegister();

    public void run() {
        if(Authenticator.auth()){
        register.registerClients();
         }
    }

}

