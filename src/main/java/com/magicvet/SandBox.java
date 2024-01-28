package main.java.com.magicvet;

import main.java.com.magicvet.comparator.ClientLastNameComparator;
import main.java.com.magicvet.comparator.PetAgeComparator;
import main.java.com.magicvet.comparator.PetNameComparator;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandBox {

    public static void main(String[] args) {
        Dog[]  dogs = {
                new Dog(Dog.Size.M, Pet.HealthState.Severe_Degree),
                new Dog(Dog.Size.S, Pet.HealthState.Moderate_Severity),
                new Dog(Dog.Size.L, Pet.HealthState.Good_Health),
                new Dog(Dog.Size.XL, Pet.HealthState.Moderate_Severity),
                new Dog(Dog.Size.XS, Pet.HealthState.Good_Health),
                new Dog(Dog.Size.M, Pet.HealthState.Severe_Degree),
                new Dog(Dog.Size.XL, Pet.HealthState.Moderate_Severity)
        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getHealthState().getHealState() - o2.getHealthState().getHealState();
            }
        });

         for(Dog dog : dogs){
            System.out.println(dog.getHealthState() + ": Size = " + dog.getSize());
        }

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        cat1.setAge("5");
        cat1.setName("Barsick");
        cat2.setAge("1");
        cat2.setName("Tigris");
        cat3.setAge("3");
        cat3.setName("Murzick");

        Cat[] catAge = {cat1, cat2, cat3};

        Arrays.sort(catAge, new PetAgeComparator());
        Arrays.sort(catAge, new PetNameComparator());

        printArray(catAge);

        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        client1.setLastName("Sedyh");
        client2.setLastName("Uriev");
        client3.setLastName("Alex");
        Client [] clients = {client1, client2, client3};

        Arrays.sort(clients);

        printArray(clients);

    }
    private static void printArray(Object[] obj) {
        for(Object object : obj){
            System.out.println(object);
        }



    }
}
