package data_structure.etc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by purblue on 6/1/16.
 */
public class Regex {
    public boolean isMatch(String str, String p){

        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(str);
        return m.find();
    }

    public static void main(String[] args){
        Regex regex = new Regex();
        System.out.println(regex.isMatch("aa","a"));
        System.out.println(regex.isMatch("aa","aa"));
        System.out.println(regex.isMatch("aaa","aa"));
        System.out.println(regex.isMatch("aa","a*"));
        System.out.println(regex.isMatch("aa",".*"));
        System.out.println(regex.isMatch("ab",".*"));
        System.out.println(regex.isMatch("aab","c*a*b"));

//        isMatch(“aa”,”a”) false
//         isMatch(“aa”,”aa”) ? true 
//        isMatch(“aaa”,”aa”) ? false 
//        isMatch(“aa”, “a*”) ? true 
//        isMatch(“aa”, “.*”) ? true 
//        isMatch(“ab”, “.*”) ? true 
//        isMatch(“aab”, “c*a*b”) ? true 
    }
}
