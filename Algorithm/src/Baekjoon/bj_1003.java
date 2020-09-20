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

		//dp�� ����� ���̴� Ƚ�� ���ϱ�
		for (int i = 3; i < 41; i++) {
			fib[i][0] = fib[i - 1][0] + fib[i - 2][0];
			fib[i][1] = fib[i - 1][1] + fib[i - 2][1];
		}
		
		//������ Ƚ����ŭ �ݺ�
		for (int i = 0; i < num; i++) {
			int n = sc.nextInt();
			System.out.println(fib[n][0] + " " + fib[n][1]);
		}
	}

}
