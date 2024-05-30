package src.tree;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            FamilyTree familyTree = new FamilyTree();

            // Родители Рината
            Human rinat = new Human("Ринат", "1967", null, Gender.MALE);
            Human raile = new Human("Раиля", "1980", null, Gender.FEMALE);

            // Дети Рината и Раили
            Human timur = new Human("Тимур", "1994", null, Gender.MALE);
            Human artem = new Human("Артём", "2005", null, Gender.MALE);
            Human karim = new Human("Карим", "2017", null, Gender.MALE);
            Human yasmina = new Human("Ясмина", "2017", null, Gender.FEMALE);
            Human azalia = new Human("Азалия", "2019", null, Gender.FEMALE);

            // Сестры Рината
            Human halida = new Human("Халида", "1962", null, Gender.FEMALE);
            Human larisa = new Human("Лариса", "1966", null, Gender.FEMALE);

            // Родители Рината
            Human halim = new Human("Халим", "1937", "2019", Gender.MALE);
            Human gulsum = new Human("Гульсум", "1940", null, Gender.FEMALE);

            // Бабушки и дедушки Рината (родители Гульсум и Халима)
            Human shamgiyamal = new Human("Шамгиямал", "1917", "1987", Gender.FEMALE);
            Human sharafey = new Human("Шарафей", "1913", "1992", Gender.MALE);
            Human fatima = new Human("Фатима", "1915", "1983", Gender.FEMALE);
            Human salim = new Human("Салим", "1910", "1943", Gender.MALE);

            // Добавление членов семьи в дерево
            familyTree.addMember(rinat);
            familyTree.addMember(raile);
            familyTree.addMember(timur);
            familyTree.addMember(artem);
            familyTree.addMember(karim);
            familyTree.addMember(yasmina);
            familyTree.addMember(azalia);
            familyTree.addMember(halida);
            familyTree.addMember(larisa);
            familyTree.addMember(halim);
            familyTree.addMember(gulsum);
            familyTree.addMember(shamgiyamal);
            familyTree.addMember(sharafey);
            familyTree.addMember(fatima);
            familyTree.addMember(salim);

            // Сохранение дерева в файл
            familyTree.saveToFile("family_tree.ser");

            // Загрузка дерева из файла
            FamilyTree loadedTree = FamilyTree.loadFromFile("family_tree.ser");

            // Вывод членов семьи
            for (Human member : loadedTree.getMembers()) {
                System.out.println(member.getName() + " " + member.getBirthDate() + " - " + (member.getDeathDate() != null ? member.getDeathDate() : "н/д"));
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
