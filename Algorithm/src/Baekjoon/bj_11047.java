package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11047 {

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		int num=Integer.parseInt(tk.nextToken());
		int money=Integer.parseInt(tk.nextToken());
		int[] coin=new int[num];
		int answer=0;
		
		for(int i=num-1;i>=0;i--){
			coin[i]=Integer.parseInt(br.readLine());
		}
		
		int n=0;
		
		while(money!=0){
			if(coin[n]>money){
				n++;
			}else if(coin[n]==money){
				answer++;
				break;
			}else{
				while(coin[n]<money){
					answer++;
					money-=coin[n];
				}
			}
		}
		System.out.println(answer);
		
	}

}
