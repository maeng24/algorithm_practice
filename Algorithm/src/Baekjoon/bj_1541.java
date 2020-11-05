package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1541 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		String []exs=str.split("\\-");
		
		int len=exs.length;
		int answer=0;
		
		String[] numbers=exs[0].split("\\+");
		int strlen=numbers.length;
		
		for(int i=0;i<strlen;i++){
			answer+=Integer.parseInt(numbers[i]);
		}

		for(int i=1;i<len;i++){
			numbers=exs[i].split("\\+");
			strlen=numbers.length;
			
			for(int j=0;j<strlen;j++){
				answer-=Integer.parseInt(numbers[j]);
			}
		}
		
		System.out.println(answer);
	}

}
