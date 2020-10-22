package Baekjoon;

import java.util.Scanner;

public class bj_2225 {
	final static int MOD=1000000000;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N =sc.nextInt();
		int K=sc.nextInt();
		
		int[][] answer=new int[K+1][N+1];
		answer[0][0]=1;
		
		for(int i=1;i<=K;i++){
			for(int j=0;j<=N;j++){
				for(int k=0;k<=j;k++){// j-k + k 로 j가 답인 결과물의 수를 누적해서 더한다
					answer[i][j]+=answer[i-1][j-k];
					answer[i][j]%=MOD;
				}
			}
		}
		
		System.out.println(answer[K][N]);
	}

}
