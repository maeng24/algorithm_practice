package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long S=Long.parseLong(br.readLine());
		long sum=0;
        int n=1;
		while(sum<=S){
			sum+=n;
            n++;
		}
		System.out.println(n-2);
	}

}
