package src.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyMembers;
    private int currentId;

    public FamilyTree() {
        this.familyMembers = new ArrayList<>();
        this.currentId = 1;
    }

    public void addHuman(String name, int birthYear, int deathYear, Gender gender) {
        familyMembers.add(new Human(currentId++, name, birthYear, deathYear, gender));
    }

    public void sortByName() {
        familyMembers.sort(Comparator.comparing(Human::getName));
    }

    public void sortByBirthYear() {
        familyMembers.sort(Comparator.comparingInt(Human::getBirthYear));
    }

    public void updateHuman(int id, String newName, int newBirthYear, int newDeathYear, Gender newGender) {
        for (Human human : familyMembers) {
            if (human.getId() == id) {
                human.setName(newName);
                human.setBirthYear(newBirthYear);
                human.setDeathYear(newDeathYear);
                human.setGender(newGender);
                break;
            }
        }
    }

    public void removeHuman(int id) {
        familyMembers.removeIf(human -> human.getId() == id);
    }

    public void printFamilyTree() {
        for (Human human : familyMembers) {
            System.out.println(human);
        }
    }
}
