package main.java.com.magicvet.comporator;

import java.util.Comparator;
import main.java.com.magicvet.model.Pet;

public class PetNameComparator implements Comparator<Pet> {

    @Override
    public int compare(Pet pet1, Pet pet2) {
        return pet1.getName().compareTo(pet2.getName());
    }
}
