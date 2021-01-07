package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2914 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(tk.nextToken());
		int i = Integer.parseInt(tk.nextToken());
		
		System.out.println((i - 1) * a + 1);
	}

}
