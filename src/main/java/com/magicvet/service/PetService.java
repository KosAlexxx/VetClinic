package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

public class PetService {

    private final static String DOG_TYPE = "dog";

    public Pet registerNewPet(){
        Pet pet = new Pet();
        System.out.print("Type (dog / cat / other): ");
        String type = Main.SCANNER.nextLine();

        if((DOG_TYPE.equals(type))){
            pet = buildDog();
        } else {
            pet = buildPet(type);
        }
        return pet;
    }

    private Pet buildDog() {
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
    }

    private Pet buildPet(String type) {
    Pet pet = new Pet();
    pet.setType(type);
    System.out.println("Age:");
    pet.setAge(Main.SCANNER.nextLine());
        System.out.println("Name:");
        pet.setName(Main.SCANNER.nextLine());
        System.out.println("Sex: (male / famale)");
        pet.setSex(Main.SCANNER.nextLine());

        return pet;
    }

}
