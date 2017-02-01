package tree;

import util.Node;

import java.util.Stack;

/**
 * Construct BST from given preorder traversal
 * http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
 */
public class SerializationBST {

    // Naive method with O(n^2)
    public Node constructBST(int[] input, int lower, int upper, int size){
        if(size==0){
            return null;
        }
        Node root = new Node(input[lower]);

        if(size==1){
            return root;
        }

        lower = lower+1;
        for(int i = lower; i<upper; i++){
            if(input[i] > root.data){
                upper = i;
                break;
            }
        }

        int lower_size = upper-lower;
        int upper_size = size - 1 - lower_size;
        root.left = constructBST(input, lower, upper, lower_size);
        root.right= constructBST(input, upper, upper + upper_size, upper_size );

        return root;
    }

    // Implement with stack: O(n), O(n) space
    public Node constructBST_stack(int[] input){
        if(input.length==0){
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node root = new Node(input[0]);
        stack.push(root);

        for(int i=1; i<input.length; i++){
            Node temp = null;
            while(!stack.isEmpty() && input[i] > stack.peek().data){
                temp = stack.pop();
            }
            if(temp!=null){
                temp.right = new Node(input[i]);
                stack.push(temp.right);
            }else{
                temp = stack.peek();
                temp.left = new Node(input[i]);
                stack.push(temp.left);
            }
        }
        return root;
    }

    public void printInorder(Node root){
        inorderTraverse(root);
        System.out.println();
    }
    public void inorderTraverse(Node root){
        if(root==null){
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.data + " ");
        inorderTraverse(root.right);
    }

    public static void main(String[] args){
        SerializationBST bst_srl = new SerializationBST();
        Node tree;
        int[] input = new int[]{10, 5, 1, 7, 40, 50};
        tree = bst_srl.constructBST(input, 0, input.length, input.length);
        bst_srl.printInorder(tree);

        tree = bst_srl.constructBST_stack(input);
        bst_srl.printInorder(tree);


        input = new int[]{10, 5, 1, 7, 40, 20, 15, 30, 50, 55};
        tree = bst_srl.constructBST(input, 0, input.length, input.length);
        bst_srl.printInorder(tree);
        tree = bst_srl.constructBST_stack(input);
        bst_srl.printInorder(tree);
    }

}
