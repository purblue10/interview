package tree;

import util.Node;

/**
 * Created by seungbumpark on 9/21/16.
 * Problem Statement: convert binary tree to doubly linked list (in in-order traverse)
 */
public class ConvertBinaryTreeToLinkedList {
    public static void main(String[] args){
        test(new int[]{2, 1, 3});
        test(new int[]{4,2,5,1,3});
        test(new int[]{4,1,3});
        test(new int[]{1,2,3});
        test(new int[]{3,2,1});
        test(new int[]{4});

    }

    public static void test(int[] input){
        Node head = generateTree(input);
        System.out.print("Inorder traverse: ");
        Node.inorderTraverse(head);
        head = convertBST(head);

        printDLL(head);
    }

    public static void printDLL(Node head){
        Node curr = head;
        System.out.print("Pring linked list: "+ curr.data+" ");
        curr=curr.right;
        while(!curr.equals(head)){
            System.out.print(curr.data+" ");

            curr = curr.right;
        }
        System.out.println();
    }
    public static void connectTwoNodes(Node a, Node b){
        a.right = b;
        b.left = a;
    }

    public static Node connectTwoLists(Node aHead, Node bHead){
        if(aHead==null)
            return bHead;
        if(bHead==null)
            return aHead;

        Node aTail = aHead.left;
        Node bTail = bHead.left;

        connectTwoNodes(aTail, bHead);
        connectTwoNodes(bTail, aHead);

        return aHead;
    }

    public static Node convertBST2(Node node){
        if(node==null)
            return null;

        Node leftList = convertBST2(node.left);
        Node rightList = convertBST2(node.right);

//        connectTwoNodes(node, node);
        connectTwoNodes(node, node);

        leftList = connectTwoLists(leftList, node);
        leftList = connectTwoLists(leftList, rightList);
        return leftList;

    }

    public static Node convertBST(Node node){
        if(node == null)
            return node;
        Node head;
        if(node.left!=null){
            Node leftHead = convertBST(node.left);
            Node leftTail = leftHead.left;
            leftTail.right = node;
            node.left = leftTail;
            leftHead.left = node;
            head = leftHead;
        }else{
            node.left = node;
            head = node;
        }
        if(node.right!=null){
            Node rightHead = convertBST(node.right);
            node.right = rightHead;
            rightHead.left.right = head;
            head.left = rightHead.left;
            rightHead.left = node;
        }else{
            node.right = head;
        }
        return head;
    }

    public static Node generateTree(int[] inputs){
        if(inputs.length==0)
            return null;

        Node head = new Node(inputs[0]);
        for(int i=1; i<inputs.length; i++){
            Node.insertBST(head, inputs[i]);
        }
        return head;
    }
}
