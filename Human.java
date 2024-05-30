package src.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private Gender gender;
    private String birthDate;
    private String deathDate;
    private List<Human> children;

    public Human(String name, Gender gender, String birthDate, String deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name + " (" + gender + "), " + birthDate + " - " + (deathDate != null ? deathDate : "present");

    }
}
