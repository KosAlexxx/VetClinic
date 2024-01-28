package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.utils.Validator;

public class ClientService {

    public Client registerNewClient() {
        Client client = null;
        System.out.println("Please provide client details:");
        System.out.print("email: ");
        String email = Main.SCANNER.nextLine();

        if(Validator.isEmailValid(email)) {
            System.out.println("FirstName: ");
            String firstName = Main.SCANNER.nextLine();

            if (Validator.isFirstNameValid(firstName)) {
                System.out.println("LastName: ");
                String lastName = Main.SCANNER.nextLine();

                if (Validator.isLastNameValid(lastName)) {
                    client = buildClient(email, firstName, lastName);

                } else {
                    System.out.println("Provided firstName is invalid.");
                }

            } else {
                System.out.println("Provided firstName is invalid.");
            }

            System.out.println("New client: " + client.getFirstName() + " " + client.getLastName() + " (" + client.getEmail() + ")");

        } else {
            System.out.println("Provided email is invalid.");
        }

        return client;
    }

    private static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        return client;
    }

}
