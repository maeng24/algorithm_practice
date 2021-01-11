package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_10026 {

	public static void dfs(boolean[][] check, String[][] arr, int a, int b) {
		if (check[a][b] == false) {
			check[a][b] = true;
			if (b < check.length - 1 && arr[a][b + 1].equals(arr[a][b])) {
				dfs(check, arr, a, b + 1);
			}
			if (a < check.length - 1 && arr[a + 1][b].equals(arr[a][b])) {
				dfs(check, arr, a + 1, b);
			}
			if (b > 0 && arr[a][b - 1].equals(arr[a][b])) {
				dfs(check, arr, a, b - 1);
			}
			if (a > 0 && arr[a - 1][b].equals(arr[a][b])) {
				dfs(check, arr, a - 1, b);
			}
			if (arr[a][b].equals("G")) {
				arr[a][b] = "R";
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		boolean[][] check = new boolean[num][num];
		String[][] arr = new String[num][num];

		for (int i = 0; i < num; i++) {
			String str = br.readLine();

			for (int j = 0; j < num; j++) {
				arr[i][j] = str.substring(j, j + 1);
			}
		}
		int answer = 0;
		int answer2 = 0;

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (!check[i][j]) {
					dfs(check, arr, i, j);
					answer++;
				}
			}
		}
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				check[i][j] = false;
			}
		}
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (!check[i][j]) {
					dfs(check, arr, i, j);
					answer2++;
				}
			}
		}
		System.out.println(answer + " " + answer2);
	}

}
