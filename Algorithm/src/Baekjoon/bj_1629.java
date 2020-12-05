package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1629 {
	
	//분할정복으로 곱셈 구하기
	public static long calc(long a, int b, int c){
		a%=c;
		if(b==0){
			return 1;
		}else if(b%2==0){
			return calc(a*a,b/2,c)%c;
		}else{
			return a*calc(a*a,(b-1)/2,c)%c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk=new StringTokenizer(br.readLine());
		
		System.out.println(calc(Long.parseLong(tk.nextToken()),Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken())));
		
	}

}
