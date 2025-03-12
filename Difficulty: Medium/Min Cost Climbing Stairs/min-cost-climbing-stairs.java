//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
     static int solve(int[] cost,int i,int[] dp){
        if(dp[i]!=-1) return dp[i];        
        if(i==cost.length-1)
            return 0;
        
        if(i==cost.length-2){
            return Math.min(cost[i+1],cost[i]);
        }
        int n1=cost[i]+solve(cost,i+1,dp);    
        
        int n2=cost[i+1]+solve(cost,i+2,dp);
        
        dp[i]=Math.min(n1,n2);
        
        return dp[i];
    }
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
          int[] dp=new int[cost.length+1];
        
        Arrays.fill(dp,-1);
        
        return solve(cost,0,dp);
    }
};