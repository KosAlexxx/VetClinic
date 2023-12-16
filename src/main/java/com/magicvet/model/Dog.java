package main.java.com.magicvet.model;

public class Dog extends Pet{
    private String size;

    @Override
    public String toString(){
        String s = getType() +
                ", Sex =  " + getSex() +
                ", Age = " + getAge() +
                ", Name = " + getName() +
                ", Size = " + getSize();
        return s;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
