package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2869 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(tk.nextToken());
		int b = Integer.parseInt(tk.nextToken());
		int v = Integer.parseInt(tk.nextToken());

		int day = (v - b - 1) / (a - b) + 1;
		System.out.println(day);
	}
}
