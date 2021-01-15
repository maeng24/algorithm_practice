package Baekjoon;

import java.util.Scanner;

public class bj_9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
        int T = sc.nextInt(); 
        int[] n = new int[10000]; 
        int[] dp = new int[11]; 
 
        dp[0] = 0; // 0
        dp[1] = 1; 
        dp[2] = 2; 
        dp[3] = 4; 
 
        for(int i = 0; i < T; i++) {
            n[i] = sc.nextInt(); 
            for(int j = 4; j <= n[i]; j++) { 
                dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
            }
        }
        for(int i = 0; i < T; i++) {
            System.out.println(dp[n[i]]);
        }

	}

}
