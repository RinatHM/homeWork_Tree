package src.tree;
import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable {
    private List<Human> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Human person) {
        this.people.add(person);
    }

    public void removePerson(int id) {
        this.people.removeIf(person -> person.getId() == id);
    }

    public Human getPersonById(int id) {
        return this.people.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    public List<Human> getPeople() {
        return this.people;
    }

    public int getNextId() {
        return this.people.size() + 1;
    }

    public void sortByName() {
        this.people.sort(Comparator.comparing(Human::getName));
    }

    public void sortByAge() {
        this.people.sort(Comparator.comparingInt(Human::getBirthYear));
    }

    public void printFamilyTree() {
        for (Human person : people) {
            System.out.println(person);
        }
    }
}
