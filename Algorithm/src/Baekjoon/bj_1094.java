package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1094 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int len=Integer.parseInt(br.readLine());
		int cnt=0;
		
		while(len>1){
			if(len%2==1){
				cnt++;
			}
			len=len/2;
		}
		System.out.println(cnt+1);

	}

}
