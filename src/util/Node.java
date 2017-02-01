package util;

/**
 * Created by purblue on 5/31/16.
 */
public class Node {
    public int data;
    public Node left, right;

    public Node(){
        this.left = this.right = null;
    }

    public Node(int data){
        this.data = data;
    }

    public static Node insertBST(Node node, int data){
        if(node==null)
            return new Node(data);
        if(data <= node.data){
            node.left = insertBST(node.left, data);
        }else{
            node.right = insertBST(node.right, data);
        }
        return node;
    }

    public static void inorderTraverse(Node node) {
        inorderTraverse_helper(node);
        System.out.println();
    }

    public static void inorderTraverse_helper(Node node){
        if(node==null)
            return;
        inorderTraverse_helper(node.left);
        System.out.print(node.data+" ");
        inorderTraverse_helper(node.right);
    }
}
