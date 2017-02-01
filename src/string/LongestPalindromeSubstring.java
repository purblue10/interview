package string;

/**
 * Created by seungbumpark on 9/19/16.
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args){
//        System.out.println(LPS("A")==1);
//        System.out.println(LPS("AA")==2);
//        System.out.println(LPS("AB")==1);
//        System.out.println(LPS("ABA")==3);

        System.out.println(LPS("a")==1);
        System.out.println(LPS("aba")==3);
        System.out.println(LPS("abca")==1);
        System.out.println(LPS("geeksskeeg")==10);

        System.out.println();

        System.out.println(LPS_DP("a")==1);
        System.out.println(LPS_DP("aba")==3);
        System.out.println(LPS_DP("abca")==1);
        System.out.println(LPS_DP("geeksskeeg")==10);
    }

    public static int LPS(String str){
        return LPS(str, 0, str.length()-1);
    }

    public static int LPS(String str, int i, int j){
        if(i==j)
            return 1;
        if(i>j)
            return 0;

        if(str.charAt(i)==str.charAt(j)){
            int lps = LPS(str, i+1, j-1);
            if(lps == j-i-1)
                return lps+2;
            else
                return Math.max(LPS(str, i, j-1), LPS(str, i+1, j));
        }else{
            return Math.max(LPS(str, i, j-1), LPS(str, i+1, j));
        }
    }


// O (n^2)
    public static int LPS_DP(String str)
    {
        int n = str.length();
        int[][] mat = new int[n][n];
        int n_lps = Integer.MIN_VALUE;
        String lps = null;
        for(int itr = 0; itr<n; itr++){
            for(int i=0; i< n-itr; i++){
                int j = i + itr;
                if(i==j){
                    mat[i][j] = 1;
                }else if(str.charAt(i)==str.charAt(j) && mat[i+1][j-1] == j-i-1){
                    mat[i][j] = mat[i+1][j-1] + 2;
                }else{
                    mat[i][j] = 0;
                }
                if(mat[i][j] > n_lps){
                    n_lps = mat[i][j];
                    lps = str.substring(i,j+1);
                }

            }
        }
        System.out.println(lps+", " + n_lps);
        return n_lps;
    }



}
