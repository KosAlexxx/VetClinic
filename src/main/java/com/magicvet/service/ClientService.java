package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

   private static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
   private static String FIRST_NAME_PATTERN = "^[A-zА-я]{1,}[- ]?[A-zА-я]{2,}$";
   private static String LAST_NAME_PATTERN = "^[A-zА-я]{1,}[- ]?[A-zА-я]{2,}$";

    public Client registerNewClient() {
        Client client = null;
        System.out.println("Please provide client details:");
        System.out.print("email: ");
        String email = Main.SCANNER.nextLine();

        if(isEmailValid(email)) {
            System.out.println("FirstName: ");
            String firstName = Main.SCANNER.nextLine();

            if (isFirstNameValid(firstName)) {
                System.out.println("LastName: ");
                String lastName = Main.SCANNER.nextLine();

                if (isLastNameValid(lastName)) {
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

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isFirstNameValid(String firstName){
        Pattern pattern = Pattern.compile(FIRST_NAME_PATTERN);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }

    private static boolean isLastNameValid(String lastName){
        Pattern pattern = Pattern.compile(LAST_NAME_PATTERN);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

}
