
public class OneLinkedList {
    private static class Node {
        Node next;
        Node previus;
        int value;
    }

    Node root;
    Node tail;

    public void add(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (root != null) {
            newNode.next = root;
            root.previus = newNode;
        } else tail = newNode;
        root = newNode;
    }

    public void renoveFirst() {
        if (root != null && root.next != null) {
            root = root.next;
            root.previus = null;
        } else {
            root = null;
            tail = null;
        }
    }

    public boolean find(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public void addEnd(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            tail = newNode;
        } else {
//            while (lastNode.next != null) lastNode = lastNode.next;
//            lastNode.next = newNode;
            newNode.previus = tail;
            tail.next = newNode;

        }
        tail = newNode;
    }

    public void renoveEnd() {
        if (root != null && root.next != null) {
//           Node preLastElement = tail;
//            Node preLastElement = root;
//            while (preLastElement.next != null) {
//                if (preLastElement.next.next == null) {
//                    preLastElement.next = null;
//                    return;
//                }
//                preLastElement = preLastElement.next;
            tail = tail.previus;
            tail.next = null;
        } else {
            tail = null;
            root = null;
        }
    }

    public void sortBabl() {
        boolean sort = true;
        while (sort) {
            sort = false;
            Node i = root;
            while (i != null && i.next != null) {
                if (i.value > i.next.value) {
                    int tmp = i.value;
                    i.value = i.next.value;
                    i.next.value = tmp;
                    sort = true;
                }
                i = i.next;
            }
        }
    }
}
