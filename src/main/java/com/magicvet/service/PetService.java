package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

public class PetService {

    private final static String DOG_TYPE = "dog";
    private final static String CAT_TYPE = "cat";

    public Pet registerNewPet(){
        Pet pet = null;
        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        if(DOG_TYPE.equals(type) || CAT_TYPE.equals(type)){
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type" + type);
        }
        return pet;
    }

  /*  private Pet buildDog() {
        Pet pet = buildPet(DOG_TYPE);
        Dog dog = petToDog(pet);

        System.out.println("Size: (xS / S / M / L / xxL): ");
        dog.setSize(Main.SCANNER.nextLine());

        return dog;
    }

    private Dog petToDog(Pet pet) {

        Dog dog = new Dog();
        dog.setType(pet.getType());
        dog.setAge(pet.getAge());
        dog.setName(pet.getName());
        dog.setSex(pet.getSex());

        return dog;
    }*/

    private Pet buildPet(String type) {
    Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog();
    pet.setType(type);
    System.out.println("Age:");
    pet.setAge(Main.SCANNER.nextLine());
        System.out.println("Name:");
        pet.setName(Main.SCANNER.nextLine());
        System.out.println("Sex: (male / female)");
        pet.setSex(Main.SCANNER.nextLine());
        System.out.println("Health state: (Good_Health / Moderate_Severity / Severe_Degree:)");
        String healthState = Main.SCANNER.nextLine();
        pet.setHealthState(Pet.HealthState.valueOf(healthState));


        if(type.equals(DOG_TYPE)){
            System.out.print("Size: (XS / S / M / L / XL): ");
            String size = Main.SCANNER.nextLine();
            ((Dog) pet).setSize(Dog.Size.valueOf(size));
        }

        return pet;
    }

}
