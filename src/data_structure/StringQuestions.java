package data_structure;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by purblue on 6/2/16.
 */
public class StringQuestions {
    public String reverseStringRecursive(String s){
        if(s.length()<=1)
            return s;
        return reverseStringRecursive(s.substring(1)) + s.charAt(0);
    }

    public void reverseStringTest(){
        System.out.println(reverseStringRecursive("1234567").equals("7654321"));
        System.out.println(reverseStringRecursive("12345678").equals("87654321"));
        System.out.println(reverseStringRecursive("ab").equals("ba"));
        System.out.println(reverseStringRecursive("a").equals("a"));
        System.out.println(reverseStringRecursive("").equals(""));
    }

    public static void main(String[] args){
        StringQuestions q= new StringQuestions();
//        q.reverseStringTest();
        int a = 1;
        String s = "asd";
        HashMap<String,String> map = new HashMap<>();
        Random rand = new Random();
        while(a<100){
            System.out.println(rand.nextInt(4));

        }


    }
}
