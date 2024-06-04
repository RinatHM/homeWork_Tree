import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

class FamilyTree implements Iterable<FamilyTree.Person> {
    private Person root;

    public FamilyTree(Person root) {
        this.root = root;
    }

    @Override
    public Iterator<Person> iterator() {
        return new FamilyTreeIterator(root);
    }

    // Класс Person предполагается, что у него есть дети, представляющие собой список или другой контейнер
    static class Person {
        String name;
        List<Person> children;

        public Person(String name) {
            this.name = name;
            this.children = new LinkedList<>();
        }

        public void addChild(Person child) {
            children.add(child);
        }

        public List<Person> getChildren() {
            return children;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // Реализация итератора для FamilyTree
    private static class FamilyTreeIterator implements Iterator<Person> {
        private Queue<Person> queue;

        public FamilyTreeIterator(Person root) {
            queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Person next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Person current = queue.poll();
            queue.addAll(current.getChildren());
            return current;
        }
    }

    public static void main(String[] args) {
        Person root = new Person("Root");
        Person child1 = new Person("Child 1");
        Person child2 = new Person("Child 2");
        Person grandChild1 = new Person("GrandChild 1");
        Person grandChild2 = new Person("GrandChild 2");

        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(grandChild1);
        child2.addChild(grandChild2);

        FamilyTree familyTree = new FamilyTree(root);

        for (Person person : familyTree) {
            System.out.println(person);
        }
    }
}
