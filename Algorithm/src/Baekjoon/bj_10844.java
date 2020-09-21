package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_10844 {

	static final int MOD=1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		
		int[][] stairnum=new int[num+1][10];
		
		for(int i=1;i<10;i++){
			stairnum[1][i]=1;
		}
		
		for(int i=2;i<=num;i++){
			stairnum[i][0]=stairnum[i-1][1]%MOD;
			for(int j=1;j<9;j++){
				stairnum[i][j]=(stairnum[i-1][j-1]+stairnum[i-1][j+1])%MOD;
			}
			stairnum[i][9]=stairnum[i-1][8]%MOD;
		}
		
		int result=0;
		
		for(int i=0;i<10;i++){
			result=(stairnum[num][i]+result)%MOD;
		}
		
		System.out.println(result);
		
	}

}
