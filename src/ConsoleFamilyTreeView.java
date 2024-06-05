package src.tree.src;

import java.util.Scanner;

class ConsoleFamilyTreeView implements FamilyTreeView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayFamilyTree(Iterable<String> familyTree) {
        for (String member : familyTree) {
            System.out.println(member);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
