package src.tree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Human rinat = new Human("Ринат", Gender.MALE, "1967", null);
        Human raile = new Human("Раиля", Gender.FEMALE, "1980", null);
        Human timur = new Human("Тимур", Gender.MALE, "1994", null);
        Human artem = new Human("Артём", Gender.MALE, "2005", null);
        Human karim = new Human("Карим", Gender.MALE, "2017", null);
        Human yasmina = new Human("Ясмина", Gender.FEMALE, "2017", null);
        Human azalia = new Human("Азалия", Gender.FEMALE, "2019", null);

        Human khalim = new Human("Халим", Gender.MALE, "1937", "2019");
        Human gulsum = new Human("Гульсум", Gender.FEMALE, "1940", null);
        Human shamgiyamal = new Human("Шамгиямал", Gender.FEMALE, "1917", "1987");
        Human sharafey = new Human("Шарафей", Gender.MALE, "1913", "1992");
        Human fatima = new Human("Фатима", Gender.FEMALE, "1915", "1983");
        Human salim = new Human("Салим", Gender.MALE, "1910", "1943");

        Human khalida = new Human("Халида", Gender.FEMALE, "1962", null);
        Human larisa = new Human("Лариса", Gender.FEMALE, "1966", null);

        rinat.addChild(timur);
        rinat.addChild(artem);
        rinat.addChild(karim);
        rinat.addChild(yasmina);
        rinat.addChild(azalia);

        gulsum.addChild(rinat);
        gulsum.addChild(khalida);
        gulsum.addChild(larisa);

        shamgiyamal.addChild(gulsum);
        sharafey.addChild(gulsum);

        khalim.addChild(rinat);
        khalim.addChild(khalida);
        khalim.addChild(larisa);

        fatima.addChild(khalim);
        salim.addChild(khalim);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addMember(rinat);
        familyTree.addMember(raile);
        familyTree.addMember(timur);
        familyTree.addMember(artem);
        familyTree.addMember(karim);
        familyTree.addMember(yasmina);
        familyTree.addMember(azalia);
        familyTree.addMember(khalim);
        familyTree.addMember(gulsum);
        familyTree.addMember(shamgiyamal);
        familyTree.addMember(sharafey);
        familyTree.addMember(fatima);
        familyTree.addMember(salim);
        familyTree.addMember(khalida);
        familyTree.addMember(larisa);

        try {
            familyTree.saveToFile("tree.txt");
            System.out.println("Family tree saved to tree.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FamilyTree loadedFamilyTree = FamilyTree.loadFromFile("tree.txt");
            System.out.println("Loaded family tree: \n" + loadedFamilyTree);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

