package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();
    public void registerClients(){
        List<Client> clients = new ArrayList<>();
        String message = "Do you want to register more clients? (y/n):";

       do {
         Client client = addClient();
         if(client != null){
             clients.add(client);
         }
        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = groupClients(clients);
        printClients(clientsByLocation);
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for(Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()){
            String content = "\n location: " + clients.getKey()
                    + "\n clients (" + clients.getValue().size() + "):"
                    + "\n\t" + clients.getValue();

            System.out.println(content);
        }
    }

    private Map<Client.Location, List<Client>> groupClients(List<Client> clients) {
        List<Client> fromKharkov = new ArrayList<>();
        List<Client> fromOdessa = new ArrayList<>();
        List<Client> fromDnepr = new ArrayList<>();
        List<Client> unknownLocation = new ArrayList<>();

        for(Client client : clients){
            switch (client.getLocation()){
                case Kharkov -> fromKharkov.add(client);
                case Odessa -> fromOdessa.add(client);
                case Dnepr -> fromDnepr.add(client);
                case Unknown -> unknownLocation.add(client);
            }
        }
        Map<Client.Location, List<Client>> clientsByLocation = new HashMap<>();
        clientsByLocation.put(Client.Location.Kharkov, fromKharkov);
        clientsByLocation.put(Client.Location.Odessa, fromOdessa);
        clientsByLocation.put(Client.Location.Dnepr, fromDnepr);
        clientsByLocation.put(Client.Location.Unknown, unknownLocation);


        return clientsByLocation;
    }

    private Client addClient(){
        Client client = clientService.registerNewClient();
        if(client != null){

            registerPets(client);
            System.out.println(client);
        }
        return client;
    }

    private void registerPets(Client client){
        String message = "Do you want to add more pets for the current client? (y/n):";
        do {
            addPet(client);

        } while(verifyRepeating(message));
    }
    private void addPet(Client client) {
        System.out.println("Do you want add a pet (y/n)");

        if (Main.SCANNER.nextLine().equals("y")) {

            System.out.println("Adding a new pet");
            Pet pet = petService.registerNewPet();

            if (pet != null) {
                client.addPet(pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                System.out.println("Pet has been added.");
            }
        }
    }

    private boolean verifyRepeating(String message){
        System.out.println(message);
        String answer = Main.SCANNER.nextLine();
        if("y".equals(answer)){
        return  true;
        } else if("n".equals(answer)){
            return false;
        } else {
            System.out.println("Incorrect answer, pleas try again");
            return verifyRepeating(message);
        }
    }
}
