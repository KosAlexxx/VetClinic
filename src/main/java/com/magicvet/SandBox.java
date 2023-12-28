package main.java.com.magicvet;

import main.java.com.magicvet.comporator.PetAgeComparator;
import main.java.com.magicvet.comporator.PetNameComparator;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import java.util.Arrays;

public class SandBox {

    public static void main(String[] args) {
        Dog []  dogs = {
                new Dog(Dog.S),
                new Dog(Dog.XS),
                new Dog(Dog.L),
                new Dog(Dog.M),
                new Dog(Dog.XL),
                new Dog(Dog.M),
                new Dog(Dog.XL)
        };

        for(Dog dog : dogs){
            System.out.println(dog.getSize());
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

       // Arrays.sort(catAge, new PetAgeComparator());
        Arrays.sort(catAge, new PetNameComparator());

        printArray(catAge);


    }

    private static void printArray(Object[] obj) {
        for(Object object : obj){
            System.out.println(object);
        }
    }
}
