package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;

public class Authenticator {

  private static String PASSWORD = "1111";

   public static boolean auth(){
        boolean accepted = false;
        for(int i = 0; i < 3; i++){
            System.out.print("Password: ");
            String input = Main.SCANNER.nextLine();

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
