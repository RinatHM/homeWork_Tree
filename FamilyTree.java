
package src.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Human> members;

    public FamilyTree() {
        members = new ArrayList<>();
    }

    public void addMember(Human human) {
        members.add(human);
    }

    // методы сериализации
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    // методы десериализации
    public static FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree) ois.readObject();
        }
    }

    // метод для получения всех членов семьи
    public List<Human> getMembers() {
        return members;
    }
}

