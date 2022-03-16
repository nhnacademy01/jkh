package day8;

public class Ex03 {
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
    public Object getFirst() { }
    public Object getLast() { }
    public Object get(int index) { }
    public int indexOf(Object o) { }
    public void clear() { }
    public Object removeFirst() { }
    public Object removeLast() { }
    public Object remove(int index) { }
}
