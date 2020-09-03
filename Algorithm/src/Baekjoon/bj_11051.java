package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11051 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		
		int n=Integer.parseInt(tk.nextToken());
		int k=Integer.parseInt(tk.nextToken());
		
		//파스칼의 삼각형
		int[][] pascal=new int[n+1][n+1];
		pascal[0][0]=1;
		
		//dp를 통해 파스칼의 삼각형을 채운다.
		for(int i=1;i<=n;i++){
			pascal[i][0]=1;
			pascal[i][i]=1;
			for(int j=1;j<i;j++){
				pascal[i][j]=(pascal[i-1][j-1]+pascal[i-1][j])%10007;
			}
		}
		System.out.println(pascal[n][k]);
	}

}
