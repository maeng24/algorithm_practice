package Baekjoon;

import java.util.Scanner;

public class bj_2563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean[][] whitepaper = new boolean[100][100];

		int answer = 0;
		//횟수 만큼 색종이를 붙이며 넓이를 구한다.
		for (int i = 0; i < num; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;

			for (int j = x, endx = x + 10; j < endx; j++) {
				for (int k = y, endy = y + 10; k < endy; k++) {
					//붙어있지 않은 곳일 경우 넓이를 체크
					if (!whitepaper[k][j]) {
						whitepaper[k][j] = true;
						answer++;
					}
				}
			}
		}

		System.out.println(answer);
	}

}
