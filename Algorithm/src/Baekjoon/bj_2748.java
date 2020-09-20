package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2748 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			int num=Integer.parseInt(br.readLine());
			
			long[] fib=new long[num+2];
			
			//피보나치 함수 초기값	
			fib[0]=0;
			fib[1]=1;
			fib[2]=1;
			
			//피보나치 함수를 구하는 dp
			for(int i=3;i<=num;i++){
				fib[i]=fib[i-1]+fib[i-2];
			}
			
			System.out.println(fib[num]);
	}

}
