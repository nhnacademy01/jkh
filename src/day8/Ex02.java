package day8;

public class Ex02 {
    int size = 0;
    Node first;

    static class Node {
        Object item;
        Node next;

        Node(Object element, Node next) {
            this.item = element;
            this.next = next;
        }
    }

    public void Ex02() {
    }

    public void addFirst(Object o) {
        if (first == null) {
            first = new Node(o, null);

        }else{
            Node next = first;
            first = new Node(o,next);
        }
        this.size++;
    }

    public void addLast(Object o) {
        if(first == null){
            first = new Node(o,null);
        }
        else{
            Node last = getLastNode();
            last.next = new Node(o,null);
        }
        this.size++;
    }

    private Node getLastNode() {
        if(first == null){
            return null;
        }
        Node current = first;
        while (true){
            if(current.next == null){
                return current;
            }
            current =current.next;
        }

    }

    public void add(int index, Object o) {

        Node prev = getNode(index -1);
        Node next = getNode(index);
        Node current = new Node(o,next);
        prev.next = current;

    }

//    private Node getNode(int index) {
////        115112
//        //return this.Node;
//    }


}
