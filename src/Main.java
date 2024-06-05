package src.tree.src;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("Ринат");
        FamilyTree<String> familyTree = new FamilyTree<>(root);
        FamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, view);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите команду: add, remove, display, exit");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    String parentName = view.getInput("Введите имя родителя: ");
                    String newMemberName = view.getInput("Введите имя нового члена: ");
                    presenter.addMember(parentName, newMemberName);
                    break;
                case "remove":
                    String memberName = view.getInput("Введите имя члена для удаления: ");
                    presenter.removeMember(memberName);
                    break;
                case "display":
                    presenter.displayFamilyTree();
                    break;
                case "exit":
                    return;
                default:
                    view.showMessage("Неизвестная команда");
                    break;
            }
        }
    }
}
