package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class bj_1003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int[][] fib = new int[41][2];

		fib[0][0] = 1;
		fib[0][1] = 0;
		fib[1][0] = 0;
		fib[1][1] = 1;
		fib[2][0] = 1;
		fib[2][1] = 1;

		//dp로 출력이 쌓이는 횟수 구하기
		for (int i = 3; i < 41; i++) {
			fib[i][0] = fib[i - 1][0] + fib[i - 2][0];
			fib[i][1] = fib[i - 1][1] + fib[i - 2][1];
		}
		
		//정해진 횟수만큼 반복
		for (int i = 0; i < num; i++) {
			int n = sc.nextInt();
			System.out.println(fib[n][0] + " " + fib[n][1]);
		}
	}

}
