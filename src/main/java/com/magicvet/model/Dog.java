package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet{

    private Size size;

    public  Dog (){

    }

    public Dog (Size size){
        this.size = size;
    }

    public Dog(Size size, HealthState healthState) {
        setHealthState(healthState);
        this.size = size;
    }

    @Override
    public String toString(){
        String s = getType() +
                ", Sex = " + getSex() +
                ", Age = " + getAge() +
                ", Name = " + getName() +
                ", Size = " + getSize();
        return s;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    public enum Size {
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);

        private final int value;

        Size(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
