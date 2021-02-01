package Baekjoon;

import java.util.Scanner;

public class bj_2010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int sum=0;
			
			for (int i = 0; i < num; i++) {
				int n = sc.nextInt();
				sum += n ;
		
			System.out.println(sum - num + 1); 
		
			}
	}

}
