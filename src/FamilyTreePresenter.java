package src.tree.src;

class FamilyTreePresenter {
    private FamilyTree<String> familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<String> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void addMember(String parentName, String newMemberName) {
        TreeNode<String> parent = familyTree.findMember(parentName);
        if (parent != null) {
            parent.addChild(new TreeNode<>(newMemberName));
            view.showMessage("Added " + newMemberName + " under " + parentName);
        } else {
            view.showMessage("Parent " + parentName + " not found.");
        }
    }

    public void removeMember(String memberName) {
        TreeNode<String> member = familyTree.findMember(memberName);
        if (member != null && member != familyTree.getRoot()) {
            TreeNode<String> parent = findParent(familyTree.getRoot(), member);
            if (parent != null) {
                parent.removeChild(member);
                view.showMessage("Removed " + memberName);
            }
        } else {
            view.showMessage("Member " + memberName + " not found or is root.");
        }
    }

    public void displayFamilyTree() {
        view.displayFamilyTree(familyTree);
    }

    private TreeNode<String> findParent(TreeNode<String> current, TreeNode<String> target) {
        for (TreeNode<String> child : current.getChildren()) {
            if (child == target) {
                return current;
            }
            TreeNode<String> parent = findParent(child, target);
            if (parent != null) {
                return parent;
            }
        }
        return null;
    }
}
