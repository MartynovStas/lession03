package Lession04;

public class RedBlackTree {
    private Node root;

    public RedBlackTree() {
        root = null;
    }

    public RedBlackTree(int[] elements) {
        root = null;
        for (int element : elements) {
            insert(element);
        }
    }

    public void insert(int key) {
        Node node = new Node(key);

        if (root == null) {
            root = node;
        } else {
            Node parent = null;
            Node current = root;

            while (current != null) {
                parent = current;

                if (key < current.key) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            if (key < parent.key) {
                parent.left = node;
            } else {
                parent.right = node;
            }

            node.parent = parent;
        }

        insertFixup(node);
    }

    public Node getLeft(Node node) {
        return node.left;
    }

    public Node getRight(Node node) {
        return node.right;
    }

    public Node getRoot() {
        return root;
    }


    public void insertFixup(Node node) {
    }

    public static class Node {
        public int key;
        public Node parent;
        public Node left;
        public Node right;
        public boolean isRed;

        public Node(int key) {
            this.key = key;
            this.isRed = true;
        }
    }

    public class Main {
        public void main(String[] args) {
            int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
            RedBlackTree tree = new RedBlackTree(elements);
            printRedBlackTree(tree.getRoot(), "", true);
        }

        private void printRedBlackTree(RedBlackTree.Node node, String indent, boolean last) {
            if (node != null) {
                System.out.print(indent);
                if (last) {
                    System.out.print("\u001B[31m" + "⬤" + "\u001B[0m" + "----");
                    indent += "     ";
                } else {
                    System.out.print("\u001B[30m" + "⬤" + "\u001B[0m" + "----");
                    indent += "|    ";
                }

                String color = node.isRed ? "\u001B[31m" : "\u001B[30m";
                System.out.println(node.key + "(" + color + "⚫" + "\u001B[0m" + ")");
                printRedBlackTree(node.left, indent, false);
                printRedBlackTree(node.right, indent, true);
            }
        }

    }
}


