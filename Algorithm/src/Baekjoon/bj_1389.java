package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1389 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());

		int[][] arr = new int[N + 1][N + 1];
		for (int j = 1; j <= N; j++) {
			for (int k = 1; k <= N; k++) {
				arr[j][k] = 100;
			}
		}
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());

			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					arr[j][k] = Math.min(arr[j][i] + arr[i][k], arr[j][k]);
				}
			}
		}
		int answer = 100000;
		int[] ans = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					ans[i] += arr[i][j];
				}
			}
			answer = Math.min(ans[i], answer);
		}
		for (int i = 0; i <= N; i++) {
			if (ans[i] == answer) {
				System.out.println(i);
				break;
			}
		}
	}

}
