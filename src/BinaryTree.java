import java.util.ArrayList;

/**
 * Created by gauthamcity12 on 8/15/15.
 */
public class BinaryTree {

    Node head = null;
    public BinaryTree (Node head){
        this.head = head;
        head.level = 0;
    }

    public void addNode(Node newNode){
        Node current = head;
        while(current != null) {
            if (newNode.data > current.data) {
                if(current.right == null){
                    current.right = newNode;
                    newNode.level = current.level+1;
                    current.adjacent.add(newNode);
                    return;
                }
                current = current.right;
            }
            else{
                if(current.left == null){
                    current.left = newNode;
                    newNode.level = current.level+1;
                    current.adjacent.add(newNode);
                    return;
                }
                current = current.left;
            }
        }
    }

    public void inOrder(Node current){
        if(current != null){
            inOrder(current.left);
            System.out.print(current.data+" ");
            inOrder(current.right);
        }
    }

    public void preOrder(Node current){
        if(current != null){
            System.out.print(current.data + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    public void postOrder(Node current){
        if(current != null){
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.data + " ");
        }
    }

    public void removeHead(){
        if(head.right == null && head.left == null){
            head = null;
        }
        else if(head.left == null){
            head = head.right;
        }
        else if(head.right == null){
            head = head.left;
        }
        Node store = head;
        Node parent = null;
        Node current = head.left;
        while(current.right != null){
            if(current.right.right == null){
                parent = current;
            }
            current = current.right;
        }
        head = current;
        head.left = store.left;
        head.right = store.right;
        head.adjacent.add(head.left);
        head.adjacent.add(head.right);
        parent.right = null;
        parent.adjacent.remove(current);
    }


    public static void main(String[] args){
        BinaryTree bt = new BinaryTree(new Node(50));
        bt.addNode(new Node(52));
        bt.addNode(new Node(48));
        bt.addNode(new Node(49));
        bt.addNode(new Node(51));
        bt.addNode(new Node(53));
        bt.addNode(new Node(47));
        bt.inOrder(bt.head);
        System.out.println();
        bt.preOrder(bt.head);
        System.out.println();
        bt.postOrder(bt.head);
        System.out.println();

        bt.removeHead();
        bt.preOrder(bt.head);
        System.out.println();
        bt.postOrder(bt.head);
        System.out.println();
    }

    public static class Node{

        public int data;
        public Node right = null;
        public Node left = null;
        public int level;
        public boolean visited = false;
        public ArrayList<Node> adjacent = new ArrayList<>();

        public Node(int data){
            this.data = data;
        }
    }
}
