package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		long [][]arr=new long[90][2];
		
		arr[0][0] = 0;
		arr[0][1] = 1;
		
		for (int i = 1; i < num; i++) {
			arr[i][0] = arr[i - 1][0] + arr[i - 1][1];
			arr[i][1] = arr[i - 1][0];

		}
		System.out.println(arr[num-1][0] + arr[num-1][1]);

	}

}
