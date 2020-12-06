package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int[] grape=new int[n+1];
		int[] sum=new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			grape[i]=Integer.parseInt(br.readLine());
		}
		
		//dp로 포도주 구하기
		sum[0]=0;
		sum[1] = grape[1];
		sum[2] = grape[1] + grape[2];
		
		//3연속 먹을 수 없기 때문에 하나씩 뛴 값중 가장 큰 것을 저장한다.
		for (int i = 3; i <= n; i++) {
			sum[i] = Math.max(sum[i-1],(Math.max(sum[i - 3] + grape[i - 1], sum[i - 2]) + grape[i]));
		}
		
		System.out.println(sum[n]);
	}

}
