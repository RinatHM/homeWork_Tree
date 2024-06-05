package src.tree.src;

import java.io.Serializable;

public class Human implements Serializable {
    private int id;
    private String name;
    private int birthYear;
    private int deathYear;
    private Gender gender;

    public Human(int id, String name, int birthYear, int deathYear, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Birth Year: %d, Death Year: %s, Gender: %s",
                id, name, birthYear, deathYear == 0 ? "N/A" : String.valueOf(deathYear), gender);
    }
}
