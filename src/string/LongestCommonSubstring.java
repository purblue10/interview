package string;

/**
 * Created by seungbumpark on 9/16/16.
 */
public class LongestCommonSubstring {
    // O(m*n) with memoization
    public static int LCS(String a, String b){
        int[][] mat = new int[a.length()+1][b.length()+1];
        int lcs = 0;
        int x = 0, y = 0;
        for(int i=0; i<mat[0].length; i++)
            mat[0][i] = 0;

        for(int i=0; i<mat.length; i++)
            mat[i][0] = 0;

        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1] + 1;
                    if(mat[i][j] > lcs){
                        lcs = mat[i][j];
                        x = i; y=j;
                    }
                }else{
                    mat[i][j] = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(mat[x][y]!=0){
            sb.append(a.charAt(x-1));
            x--; y--;
        }

        System.out.println(lcs);
        System.out.println(sb.reverse().toString());
        return lcs;
    }

    public static void main(String[] args){
        String a = "tutorialhorizon";
        String b = "dynamictutorialProgramming";
        LCS(a,b);
    }
}
