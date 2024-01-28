package main.java.com.magicvet.model;

public class Cat extends Pet{
    public Cat() {

    }
    @Override
    public String toString(){
        String s = getType() +
                ", Sex =  " + getSex() +
                ", Age = " + getAge() +
                ", Name = " + getName();
        return s;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
