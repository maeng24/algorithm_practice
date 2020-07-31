package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		
		int[][] ascnum=new int[num+1][10];
		int answer=0;
		
		// 마지막 수는 각자 오르막 수다.
		for(int i=0;i<10;i++){
			ascnum[1][i]=1;
		}
		
		// 오르막 수 구하기
		for(int i=2;i<=num;i++){
			for(int j=0;j<10;j++){
				for(int k=0;k<=j;k++){
					ascnum[i][j]+=ascnum[i-1][k];
					ascnum[i][j]%=10007;
				}
			}
		}
		
		//마지막 자리별로 나온 오르막 수를 모두 합친다.
		for(int i=0;i<10;i++){
			answer+=ascnum[num][i];
		}
		
		System.out.println(answer%10007);
	}
}
