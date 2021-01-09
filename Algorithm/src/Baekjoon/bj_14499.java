package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14499 {

	public static void main(String[] args) throws IOException {

		int n, m, x, y, num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(tk.nextToken());
		m = Integer.parseInt(tk.nextToken());
		x = Integer.parseInt(tk.nextToken());
		y = Integer.parseInt(tk.nextToken());
		num = Integer.parseInt(tk.nextToken());

		int[][] arr = new int[n][m];
		int a = 0;

		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {

				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		int[] dice1 = new int[6];
		int temp = 0;
		tk = new StringTokenizer(br.readLine(), " ");
		// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
		for (int i = 0; i < num; i++) {
			int dr = Integer.parseInt(tk.nextToken());

			if (dr == 1) {
				if (!(y + 1 >= m)) {
					if (arr[x][y + 1] == 0) {
						arr[x][y + 1] = dice1[2];
					} else {
						dice1[2] = arr[x][y + 1];
						arr[x][y + 1] = 0;
					}
					temp = dice1[3];
					dice1[3] = dice1[0];
					dice1[0] = dice1[2];
					dice1[2] = dice1[5];
					dice1[5] = temp;
					y = y + 1;
					System.out.println(dice1[5] + "\n");
				}
			} else if (dr == 2) {
				if (!(y - 1 < 0)) {
					if (arr[x][y - 1] == 0) {
						arr[x][y - 1] = dice1[3];
					} else {
						dice1[3] = arr[x][y - 1];
						arr[x][y - 1] = 0;
					}
					temp = dice1[2];
					dice1[2] = dice1[0];
					dice1[0] = dice1[3];
					dice1[3] = dice1[5];
					dice1[5] = temp;
					y = y - 1;
					System.out.println(dice1[5] + "\n");
				}
			} else if (dr == 3) {
				if (!(x - 1 < 0)) {
					if (arr[x - 1][y] == 0) {
						arr[x - 1][y] = dice1[1];
					} else {
						dice1[1] = arr[x - 1][y];
						arr[x - 1][y] = 0;
					}
					temp = dice1[5];
					dice1[5] = dice1[4];
					dice1[4] = dice1[0];
					dice1[0] = dice1[1];
					dice1[1] = temp;
					x = x - 1;
					System.out.println(dice1[5] + "\n");
				}
			} else if (dr == 4) {
				if (!(x + 1 >= n)) {
					if (arr[x + 1][y] == 0) {
						arr[x + 1][y] = dice1[4];
					} else {
						dice1[4] = arr[x + 1][y];
						arr[x + 1][y] = 0;
					}

					temp = dice1[1];
					dice1[1] = dice1[0];
					dice1[0] = dice1[4];
					dice1[4] = dice1[5];
					dice1[5] = temp;
					x = x + 1;
					System.out.println(dice1[5] + "\n");

				}
			}
		}
	}

}
