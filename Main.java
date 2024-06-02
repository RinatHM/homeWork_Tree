import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Добавление первоначальных данных
        familyTree.addPerson(new Human(1, "Ринат", 1967, Gender.MALE));
        familyTree.addPerson(new Human(2, "Раиля", 1980, Gender.FEMALE));
        familyTree.addPerson(new Human(3, "Халим", 1937, 2019, Gender.MALE));
        familyTree.addPerson(new Human(4, "Гульсум", 1940, Gender.FEMALE));
        familyTree.addPerson(new Human(5, "Шамгиямал", 1917, 1987, Gender.FEMALE));
        familyTree.addPerson(new Human(6, "Шарафей", 1913, 1992, Gender.MALE));
        familyTree.addPerson(new Human(7, "Фатима", 1915, 1983, Gender.FEMALE));
        familyTree.addPerson(new Human(8, "Салим", 1910, 1943, Gender.MALE));
        familyTree.addPerson(new Human(9, "Тимур", 1994, Gender.MALE));
        familyTree.addPerson(new Human(10, "Артём", 2005, Gender.MALE));
        familyTree.addPerson(new Human(11, "Карим", 2017, Gender.MALE));
        familyTree.addPerson(new Human(12, "Ясмина", 2017, Gender.FEMALE));
        familyTree.addPerson(new Human(13, "Азалия", 2019, Gender.FEMALE));
        familyTree.addPerson(new Human(14, "Халида", 1962, Gender.FEMALE));
        familyTree.addPerson(new Human(15, "Лариса", 1966, Gender.FEMALE));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Приветствие! Какое действие необходимо сделать? Введите число от 1 до 5:");
            System.out.println("1 - Добавить человека");
            System.out.println("2 - Сортировать список людей по имени");
            System.out.println("3 - Сортировать людей по возрасту");
            System.out.println("4 - Корректировать данные людей");
            System.out.println("5 - Удалить человека");
            System.out.println("6 - Вывести всех людей");
            System.out.println("0 - Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPerson(familyTree, scanner);
                    break;
                case 2:
                    familyTree.sortByName();
                    break;
                case 3:
                    familyTree.sortByAge();
                    break;
                case 4:
                    editPerson(familyTree, scanner);
                    break;
                case 5:
                    deletePerson(familyTree, scanner);
                    break;
                case 6:
                    familyTree.printFamilyTree();
                    break;
                case 0:
                    saveToFile(familyTree, "tree.txt");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void addPerson(FamilyTree familyTree, Scanner scanner) {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите год рождения:");
        int birthYear = scanner.nextInt();
        System.out.println("Введите пол (MALE/FEMALE):");
        Gender gender = Gender.valueOf(scanner.next().toUpperCase());
        System.out.println("Введите год смерти (или 0, если жив):");
        int deathYear = scanner.nextInt();

        Human person = deathYear == 0 ?
                new Human(familyTree.getNextId(), name, birthYear, gender) :
                new Human(familyTree.getNextId(), name, birthYear, deathYear, gender);

        familyTree.addPerson(person);
    }

    private static void editPerson(FamilyTree familyTree, Scanner scanner) {
        System.out.println("Введите ID человека для редактирования:");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Human person = familyTree.getPersonById(id);
        if (person == null) {
            System.out.println("Человек с таким ID не найден.");
            return;
        }

        System.out.println("Введите новое имя (или нажмите Enter для пропуска):");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            person.setName(name);
        }

        System.out.println("Введите новый год рождения (или 0 для пропуска):");
        int birthYear = scanner.nextInt();
        if (birthYear != 0) {
            person.setBirthYear(birthYear);
        }

        System.out.println("Введите новый год смерти (или 0 для пропуска):");
        int deathYear = scanner.nextInt();
        if (deathYear != 0) {
            person.setDeathYear(deathYear);
        }
    }

    private static void deletePerson(FamilyTree familyTree, Scanner scanner) {
        System.out.println("Введите ID человека для удаления:");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Human person = familyTree.getPersonById(id);
        if (person == null) {
            System.out.println("Человек с таким ID не найден.");
            return;
        }

        System.out.println("Вы уверены, что хотите удалить " + person.getName() + "? (yes/no)");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            familyTree.removePerson(id);
            System.out.println("Человек удалён.");
        } else {
            System.out.println("Удаление отменено.");
        }
    }

    private static void saveToFile(FamilyTree familyTree, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Human person : familyTree.getPeople()) {
                writer.write(person.toString());
                writer.newLine();
            }
            System.out.println("Данные сохранены в " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }
}
