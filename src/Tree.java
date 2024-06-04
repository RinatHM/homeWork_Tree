package src.tree.src;

import java.util.Iterator;
import java.util.Stack;

class Tree<T> implements Iterable<T> {
    private TreeNode<T> root;

    public Tree(TreeNode<T> root) {
        this.root = root;
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
