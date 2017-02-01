package string;

/**
 * Created by seungbumpark on 9/16/16.
 * Recur­sion:

 Start comparing strings in reverse order one character at a time.

 Now we have 2 cases -

 1. Both characters are same:
    add 1 to the result and remove the last char­ac­ter from both the strings and make recur­sive call to the mod­i­fied strings.
 2. Both characters are different:
    Remove the last char­ac­ter of String 1 and make a recur­sive call and remove the last char­ac­ter from String 2 and make a recur­sive and then return the max from returns of both recur­sive calls. see exam­ple below

 Case 1:
    String A: "ABCD", String B: "AEBD"
    LCS("ABCD", "AEBD") = 1 + LCS("ABC", "AEB")

 Case 2:
     String A: "ABCDE", String B: "AEBDF"
     LCS("ABCDE", "AEBDF") = Max(LCS("ABCDE", "AEBD"), LCS("ABCD", "AEBDF"))
 */
public class LongestCommonSubsequence {
    // O(2^n) without memoization
    public static int LCS(String a, String b){
        if(a.length()==0 || b.length()==0)
            return 0;
        if(a.charAt(a.length()-1)==b.charAt(b.length()-1)){
            // Add 1 to the result and remove the last character from both
            // the strings and make recursive call to the modified strings.
            return 1 + LCS(a.substring(0,a.length()-1), b.substring(0,b.length()-1));
        }else{
            return Math.max(LCS(a.substring(0,a.length()-1), b),
                    LCS(a, b.substring(0,b.length()-1)));
        }
    }

    public static int LCSdynamic(String a, String b){
        int[][] mat = new int[a.length()+1][b.length()+1];
        for(int i=0; i<mat.length;i++){
            mat[i][0] = 0;
        }
        for(int i=0; i<mat[0].length;i++){
            mat[0][i] = 0;
        }

        for(int i=1; i <= a.length(); i++){
            for(int j=1;j <= b.length();j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1] + 1;
                }else{
                    mat[i][j] = Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        return mat[a.length()][b.length()];
    }

    public static void main(String[] args){
        System.out.println(LCS("ACBDEA","ABCDA"));
        System.out.println(LCSdynamic("ACBDEA","ABCDA"));
    }
}
