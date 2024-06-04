package src.tree.src;

import java.util.ArrayList;
import java.util.List;

class TreeNode<T> {
    T data;
    List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {
        children.add(child);
    }

    public T getData() {
        return data;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }
}

class FamilyMember {
    String name;

    public FamilyMember(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
