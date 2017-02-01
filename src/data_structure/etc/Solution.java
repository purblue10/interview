package data_structure.etc;

import java.util.HashMap;

/**
 * Created by purblue on 6/1/16.
 */
public class Solution {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aa",".*"));
    }

    public class Node{
        HashMap<Character, Node> childs;
        public Node(){
            childs = new HashMap<>();
        }

        public boolean isEmpty(){
            return childs.isEmpty();
        }

    }
    public boolean isMatch(String s, String p) {
        Node fsm = buildFSM(p);
        Node result = null;
        result = searchFSM(s, fsm);

        return (result!=null)? true:false;
    }

    public Node buildFSM(String p){
        Node root = new Node();
        Node curr = root;
        for(int i=0; i<p.length(); i++){
            Node next = new Node();
            char c = p.charAt(i);
            if(i<p.length()-1 && p.charAt(i+1) == '*'){
                curr.childs.put(c,curr);
                curr.childs.put('@',next);
                i++;
            }else{
                curr.childs.put(c,next);
            }
            curr = next;
        }
        return root;
    }

    public Node searchFSM(String s, Node root){
        if(root==null || s.length()==0){
            return root;
        }
        System.out.println(s);
        Node c_node = searchFSM(s.substring(1), root.childs.get(s.charAt(0)));
        Node wild_node = searchFSM(s.substring(0), root.childs.get('.'));
        Node eps_node = searchFSM(s.substring(0), root.childs.get('@'));

        if(c_node !=null){
            return c_node;
        }else if(wild_node!=null){
            return wild_node;
        }else{
            return eps_node;
        }
    }

}
