package src.tree.src;
import java.util.Iterator;
import java.util.Stack;

class FamilyTree<T> implements Iterable<T> {
    private TreeNode<T> root;

    public FamilyTree(TreeNode<T> root) {
        this.root = root;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public TreeNode<T> findMember(T data) {
        if (root == null) return null;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.pop();
            if (current.getData().equals(data)) {
                return current;
            }
            for (int i = current.getChildren().size() - 1; i >= 0; i--) {
                stack.push(current.getChildren().get(i));
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new DFSIterator<>(root);
    }

    private static class DFSIterator<T> implements Iterator<T> {
        private Stack<TreeNode<T>> stack = new Stack<>();

        public DFSIterator(TreeNode<T> root) {
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements");
            }
            TreeNode<T> current = stack.pop();
            for (int i = current.getChildren().size() - 1; i >= 0; i--) {
                stack.push(current.getChildren().get(i));
            }
            return current.getData();
        }
    }
}
