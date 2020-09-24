package Baekjoon;

import java.util.Scanner;

public class bj_9251 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		char[] ch1=sc.next().toCharArray();
		char[] ch2=sc.next().toCharArray();
		
		int ch1_len=ch1.length;
		int ch2_len=ch2.length;
		
		int[][] lcs=new int[ch1_len+1][ch2_len+1];
		
		for(int i=0;i<ch1_len;i++){
			for(int j=0;j<ch2_len;j++){
				if(ch1[i]==ch2[j]){
					lcs[i+1][j+1]=lcs[i][j]+1;
				}else{
					lcs[i+1][j+1]=Math.max(lcs[i][j+1], lcs[i+1][j]);
				}
			}
		}
		
		System.out.println(lcs[ch1_len][ch2_len]);
	}
}
