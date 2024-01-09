package main.java.com.magicvet.model;

import java.util.Objects;

public abstract class Pet {

    private HealthState healthState;
    private String type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;

    @Override
    public String toString(){
        return  type + ", sex = " + sex
                + ", age = " + age
                + ", name = " + name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHealthState(HealthState healthState){
        this.healthState = healthState;
    }

    public HealthState getHealthState(){
        return healthState;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName);
    }

    public enum HealthState{
        Good_Health(1),
        Moderate_Severity(2),
        Severe_Degree(3),
        UNKNOWN(0);

        private int value;

        HealthState(int value){
            this.value = value;
        }

        public int getHealState(){
            return value;
        }
}

}
