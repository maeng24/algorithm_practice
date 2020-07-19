package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int len=Integer.parseInt(br.readLine());
		int[] arr=new int[len+2];
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		
		for(int i=3;i<=len;i++){
			arr[i]=arr[i-1]+arr[i-2];
			arr[i]%=15746;
		}
		System.out.println(arr[len]);
	}
}
