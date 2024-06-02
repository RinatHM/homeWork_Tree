package src.tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Adding initial family members
        familyTree.addHuman("Ринат", 1967, 0, Gender.MALE);
        familyTree.addHuman("Раиля", 1980, 0, Gender.FEMALE);
        familyTree.addHuman("Халим", 1937, 2019, Gender.MALE);
        familyTree.addHuman("Гульсум", 1940, 0, Gender.FEMALE);
        familyTree.addHuman("Шамгиямал", 1917, 1987, Gender.FEMALE);
        familyTree.addHuman("Шарафей", 1913, 1992, Gender.MALE);
        familyTree.addHuman("Фатима", 1915, 1983, Gender.FEMALE);
        familyTree.addHuman("Салим", 1910, 1943, Gender.MALE);
        familyTree.addHuman("Тимур", 1994, 0, Gender.MALE);
        familyTree.addHuman("Артём", 2005, 0, Gender.MALE);
        familyTree.addHuman("Карим", 2017, 0, Gender.MALE);
        familyTree.addHuman("Ясмина", 2017, 0, Gender.FEMALE);
        familyTree.addHuman("Азалия", 2019, 0, Gender.FEMALE);
        familyTree.addHuman("Халида", 1962, 0, Gender.FEMALE);
        familyTree.addHuman("Лариса", 1966, 0, Gender.FEMALE);

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
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.println("Введите имя:");
                    String name = scanner.nextLine();
                    System.out.println("Введите год рождения:");
                    int birthYear = scanner.nextInt();
                    System.out.println("Введите год смерти (или 0, если жив):");
                    int deathYear = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.println("Введите пол (MALE/FEMALE):");
                    Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
                    familyTree.addHuman(name, birthYear, deathYear, gender);
                    break;
                case 2:
                    familyTree.sortByName();
                    System.out.println("Отсортировано по имени:");
                    familyTree.printFamilyTree();
                    break;
                case 3:
                    familyTree.sortByBirthYear();
                    System.out.println("Отсортировано по возрасту:");
                    familyTree.printFamilyTree();
                    break;
                case 4:
                    System.out.println("Введите ID человека для редактирования:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.println("Введите новое имя:");
                    String newName = scanner.nextLine();
                    System.out.println("Введите новый год рождения:");
                    int newBirthYear = scanner.nextInt();
                    System.out.println("Введите новый год смерти (или 0, если жив):");
                    int newDeathYear = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.println("Введите новый пол (MALE/FEMALE):");
                    Gender newGender = Gender.valueOf(scanner.nextLine().toUpperCase());
                    familyTree.updateHuman(id, newName, newBirthYear, newDeathYear, newGender);
                    break;
                case 5:
                    System.out.println("Введите ID человека для удаления:");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    familyTree.removeHuman(removeId);
                    break;
                case 6:
                    familyTree.printFamilyTree();
                    break;
                case 0:
                    System.out.println("Выход.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");
                    break;
            }
        }
    }
}
