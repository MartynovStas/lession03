public class reverse {
    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }

        Node previous = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }
}
}
