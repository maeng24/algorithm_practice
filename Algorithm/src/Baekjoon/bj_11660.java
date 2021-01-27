package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11660 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());

		int[][] dp = new int[N+1][N+1];

		//숫자를 받으면서 dp를 진행한다.
		for (int i = 1; i <= N; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				if(i==1){
					dp[i][j]+=dp[i][j-1]+Integer.parseInt(tk.nextToken());
				}else if(j==1){
					dp[i][j]+=dp[i-1][j]+Integer.parseInt(tk.nextToken());
				}else{
					dp[i][j]+=	dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+Integer.parseInt(tk.nextToken());
				}
			}
		}

		//해당 구간의 합 만큼만을 계산해서 출력해준다.
		for (int i = 1; i <= M; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			int x1=Integer.parseInt(tk.nextToken());
			int y1=Integer.parseInt(tk.nextToken());
			int x2=Integer.parseInt(tk.nextToken());
			int y2=Integer.parseInt(tk.nextToken());
			System.out.println(dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]);
		}
	}
}
