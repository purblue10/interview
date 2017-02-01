package data_structure.main;

/**
 * Created by purblue on 6/24/16.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(findWays(3,2));
    }

    public static int findWays(int m, int n){
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        dfs(dp, 0, 0);
        return dp[0][0];
    }

    public static void dfs(int[][] dp, int x, int y){
        if(x==dp.length-1 || y==dp[0].length-1){
            dp[x][y] = 1;
            return;
        }
        if(dp[x+1][y]==0)
            dfs(dp, x+1, y);
        if(dp[x][y+1]==0)
            dfs(dp, x, y+1);
        dp[x][y] = dp[x+1][y] + dp[x][y+1];

    }
}
