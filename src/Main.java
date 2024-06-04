package src.tree.src;

public class Main {
    public static void main(String[] args) {
        // Создаем узлы дерева
        TreeNode<FamilyMember> rinat = new TreeNode<>(new FamilyMember("Ринат"));
        TreeNode<FamilyMember> child1 = new TreeNode<>(new FamilyMember("Ильдар"));
        TreeNode<FamilyMember> child2 = new TreeNode<>(new FamilyMember("Алия"));
        TreeNode<FamilyMember> grandchild1 = new TreeNode<>(new FamilyMember("Рамиль"));
        TreeNode<FamilyMember> grandchild2 = new TreeNode<>(new FamilyMember("Лейла"));

        // Строим дерево
        rinat.addChild(child1);
        rinat.addChild(child2);
        child1.addChild(grandchild1);
        child2.addChild(grandchild2);

        // Создаем дерево
        Tree<FamilyMember> familyTree = new Tree<>(rinat);

        // Используем итератор для обхода дерева
        for (FamilyMember member : familyTree) {
            System.out.println(member);
        }
    }
}
