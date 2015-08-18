import java.util.*;
import java.util.LinkedList;

/**
 * Created by gauthamcity12 on 8/17/15.
 */
public class Search {
    public static boolean bfs(BinaryTree bt, int value){
        BinaryTree.Node current = bt.head;
        Queue<BinaryTree.Node> nodeList = new LinkedList<BinaryTree.Node>();
        nodeList.add(current);

        while(!nodeList.isEmpty()){

            current = nodeList.peek();
            current.visited = true;
            if(current.data == value){
                return true;
            }
            for(BinaryTree.Node adjs : current.adjacent){
                if(!adjs.visited){
                    nodeList.add(adjs);
                }
            }
            System.out.println("Searched: "+current.data);
            nodeList.poll();

        }
        return false;
    }

    public static boolean dfs(BinaryTree bt, int value){
        BinaryTree.Node current = bt.head;
        Stack<BinaryTree.Node> nodeStack = new Stack<>();
        nodeStack.add(current);

        while(!nodeStack.isEmpty()){
            current = nodeStack.pop();
            current.visited = true;
            if(current.data == value){
                return true;
            }
            for(BinaryTree.Node adjs : current.adjacent){
                if(!adjs.visited){
                    nodeStack.add(adjs);
                }
            }
            System.out.println("Searched: "+current.data);
        }

        return false;
    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree(new BinaryTree.Node(50));
        bt.addNode(new BinaryTree.Node(52));
        bt.addNode(new BinaryTree.Node(48));
        bt.addNode(new BinaryTree.Node(49));
        bt.addNode(new BinaryTree.Node(51));
        bt.addNode(new BinaryTree.Node(53));
        bt.addNode(new BinaryTree.Node(47));

        //System.out.println(bfs(bt, 46));
        //System.out.println(bfs(bt, 47));
        System.out.println(dfs(bt, 46));
        //System.out.println(dfs(bt, 47));
    }


}
