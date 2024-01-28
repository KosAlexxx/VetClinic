package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class Client implements Comparable<Client> {

        private static final Comparator<Client> COMPARATOR = comparing((Client client) -> client.lastName)
            .thenComparing(client -> client.firstName)
            .thenComparing(client -> client.email);
         private  String firstName;
         private String lastName;
         private String email;
         private List<Pet> pets = new ArrayList<>();
         private  static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
         private final LocalDateTime registrationDate = LocalDateTime.now();

         @Override
         public String toString(){
             return "Client {"
                     + "\n\tFirst name = " + firstName
                     + ", Last name = " + lastName
                     + ", Email = " + email
                     + ", Registration date: " + registrationDate.format(FORMATTER)
                     + ",\n\tPets = " + pets
                     + "\n}";
         }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pets, client.pets);
    }

    @Override
    public int hashCode() {

             return Objects.hash(firstName, lastName, email, pets);
    }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public List <Pet> getPet() {
            return pets;
        }

        public void setPet(List <Pet> pet) {
            this.pets = pets;
        }

        public void addPet(Pet pet){
             pets.add(pet);
        }

    @Override
    public int compareTo(Client thatClient) {
        return COMPARATOR.compare(this, thatClient);
    }
}
