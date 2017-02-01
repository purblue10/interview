package data_structure.playground;

import java.util.*;

/**
 * Created by purblue on 6/2/16.
 */
public class PlaygroundMain {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // if left child is null, right child should be null as well.
        if(root ==null || root.left == null)
            return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        // if you don't remove the edges, it gives you 'memory limit exceeded' error.
        root.left = null;
        root.right = null;

        return newRoot;
    }

    public void test2(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root = upsideDownBinaryTree(root);

        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }

    public static void main(String[] args){
        PlaygroundMain pg = new PlaygroundMain();
        pg.test2();
//        Map<Integer, Integer[]> map = new Map<>();
    }
    public class ArrayKey{
        int[] array = new int['z'-'a'+1];

        public ArrayKey(String s){
            for(int i=0; i<s.length();i++){
                array[s.charAt(i)-'a']++;
            }
        }

        public int hashCode(){
            return Arrays.hashCode(array);
        }

        public boolean equals(Object obj) {
            return Arrays.equals(array, ((ArrayKey)obj).array);
        }
    }

    public void test(){



    }


    public static class StringLengthComparator implements Comparator<String>
    {
        @Override
        public int compare(String x, String y)
        {
            // Assume neither string is null. Real code should
            // probably be more robust
            // You could also just return x.length() - y.length(),
            // which would be more efficient.
            if (x.length() < y.length())
            {
                return -1;
            }
            if (x.length() > y.length())
            {
                return 1;
            }
            return 0;
        }
    }

    public static void add(StringBuilder arr){
        arr.append("123");
        arr.append("abc");
    }

    public static int hashFunction(int k){
        int p = 59;
        int m = 5;
        Random rand = new Random();
        int a = rand.nextInt(p-1)+1;
        int b = rand.nextInt(p);

        return ((a*k+b)%p)%m;
    }

    public static int getIndex(){
        Random rand = new Random();
        int[] arr = {3,4,5};
        int sum = rand.nextInt(3+4+5)+1;
        int i = 0;
        while(sum>0){
            sum -=arr[i++];
        }
        return i;
    }
}
