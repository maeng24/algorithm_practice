package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());

		int[][] schedule=new int[N+1][N+1];
		int[] max_pay=new int[N+1];
		
		for(int i=1;i<=N;i++){
			StringTokenizer tk=new StringTokenizer(br.readLine()," ");
			schedule[i][0]=Integer.parseInt(tk.nextToken())+i-1;
			schedule[i][1]=Integer.parseInt(tk.nextToken());
		}
		
		//dp로 최대 효율 구하기
		for(int i=1;i<=N;i++){
			for(int j=i;j>0;j--){
				if(schedule[j][0]<=i){
					max_pay[i]=Math.max(max_pay[i], max_pay[j-1]+schedule[j][1]);
				}
			}
		}
		
		System.out.println(max_pay[N]);
	}
}
