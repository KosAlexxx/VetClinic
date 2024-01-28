package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Client;

import java.util.Comparator;

public class ClientLastNameComparator implements Comparator<Client> {
    @Override
    public int compare(Client client1, Client client2) {

        return client1.getLastName().compareTo(client2.getLastName());
    }
}
