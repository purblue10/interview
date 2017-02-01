package string;

/**
 * Created by seungbumpark on 9/19/16.
 */
public class LongestPalindromeSubsequence {
    public static void main(String[] args){
        System.out.println(LPS("A")==1);
        System.out.println(LPS("AA")==2);
        System.out.println(LPS("AB")==1);
        System.out.println(LPS("ABA")==3);
        System.out.println(LPS("BBABCBCAB")==7);
        System.out.println(LPS("AABCDEBAZ")==5);

        System.out.println();

        System.out.println(LPS_DP("A")==1);
        System.out.println(LPS_DP("AA")==2);
        System.out.println(LPS_DP("AB")==1);
        System.out.println(LPS_DP("ABA")==3);
        System.out.println(LPS_DP("BBABCBCAB")==7);
        System.out.println(LPS_DP("AABCDEBAZ")==5);
    }

    /**
     * LPS(i, i) = 1 for all indexes i in given sequence
     * if (X[i]==X[j]):
     *      LPS(i,j) =  L(i+1, j-1) + 2
     * if (X[i]!=X[j]):
     *      LPS(i,j) =  max{LPS(i+1, j),LPS(i, j-1)}
     * */
    public static int LPS(String str){
        return LPS(str, 0, str.length()-1);
    }

    public static int LPS(String str, int i, int j){
        if(i==j)    return 1;
        if(i>=j)    return 0;

        if(str.charAt(i)==str.charAt(j)){
            return LPS(str, i+1, j-1)+2;
        }else{
            return Math.max(LPS(str, i, j-1), LPS(str, i+1, j));
        }
    }
    // O (n^2)
    public static int LPS_DP(String str){
        int n = str.length();
        int[][] mat = new int[n][n];
        for(int itr = 0; itr<n; itr++){
            for(int i=0; i< n-itr; i++){
                int j = i + itr;
                if(i==j){
                    mat[i][j] = 1;
                }else if(str.charAt(i)==str.charAt(j)){
                    mat[i][j] = mat[i+1][j-1] + 2;
                }else{
                    mat[i][j] = Math.max(mat[i+1][j], mat[i][j-1]);
                }
            }
        }
        return mat[0][n-1];

    }
}
