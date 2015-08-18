/**
 * Created by gauthamcity12 on 8/13/15.
 */
public class LinkedList {

    public Node head;
    public int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public void addNode(Node node){
        if(size == 0){
            head = node;
            size++;
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = node;
        node.prev = current;
        size++;
    }

    public Node removeHead(){
        if(size == 0){
            return null;
        }
        if(size == 1){
            Node current = head;
            head = null;
            return current;
        }
        Node current = head;
        Node next = current.next;
        head = next;
        next.prev = null;

        size--;
        return current;
    }

    public Node removeTail(){
        if(size == 0){
            return null;
        }
        if(size == 1){
            Node current = head;
            head = null;
            return current;
        }

        Node current = head;
        Node prev = null;
        while(current.next != null){
            current = current.next;
            if(current.prev != null){
                prev = current.prev;
            }
        }
        prev.next = null;
        current.prev = null;
        size--;
        return current;
    }

    @Override
    public String toString(){
        Node current = head;
        while(current != null){
            System.out.print(current.data+"-");
            current = current.next;
        }
        System.out.println("");
        System.out.println("list printed");
        return "";
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addNode(new Node(1));
        list.addNode(new Node(2));
        list.addNode(new Node(3));
        list.removeHead();
        list.removeTail();
        list.toString();
    }

    private static class Node{

        public int data;
        public Node next = null;
        public Node prev = null;

        public Node(int data){
            this.data = data;
        }
    }
}
