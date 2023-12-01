package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String FIRST_NAME_PATTERN = "^[A-zА-я]{1,}[- ]?[A-zА-я]{2,}$";
    static String LAST_NAME_PATTERN = "^[A-zА-я]{1,}[- ]?[A-zА-я]{2,}$";

    public static void main(String[] args) {
        run();

    }

    private static void registerNewClient() {
        System.out.println("Please provide client details:");
        System.out.print("email: ");
        String email = SCANNER.nextLine();

        if(isEmailValid(email)) {
            String validEmail = email;

            System.out.println("FirstName: ");
            String firstName = SCANNER.nextLine();

            Client client = null;
            if (isFirstNameValid(firstName)) {
                String validFirstName = firstName;

                System.out.println("LastName: ");
                String LastName = SCANNER.nextLine();

                if (isLastNameValid(firstName)) {
                    String validLastName = LastName;
                    client = buildClient(validEmail, validFirstName, validLastName);
                } else {
                    System.out.println("Provided firstName is invalid.");
                }
            } else {
                System.out.println("Provided firstName is invalid.");
            }

            System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }
    }

    private static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.email = email;
        client.firstName = firstName;
        client.lastName = lastName;
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

    private static void run() {
        if(auth()){
            registerNewClient();
        }
    }

    static boolean auth(){
        boolean accepted = false;
        for(int i = 0; i < 3; i++){
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if(PASSWORD.equals(input)){
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Pleas check your password");
            }
        }
        System.out.println(accepted? "Welcome to the Magic vet!" : " Application has been blocked.");
        return accepted;
    }
}