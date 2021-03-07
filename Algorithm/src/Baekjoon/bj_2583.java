package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_2583 {

	static int x, y, n;
	static boolean[][] check = new boolean[100][100];
	static int[] move_x = { 1, 0, -1, 0 };
	static int[] move_y = { 0, 1, 0, -1 };

	public static int dfs(int xx, int yy) {
		int num = 1;
		check[xx][yy] = true;
		for (int i = 0; i < 4; i++) {
			int a = xx + move_x[i];
			int b = yy + move_y[i];
			if (check[a][b] == false && a < x && a >= 0 && b < y && b >= 0) {
				num += dfs(a, b);
			}
		}
		return num;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int y = Integer.parseInt(tk.nextToken());
		int x = Integer.parseInt(tk.nextToken());
		int n = Integer.parseInt(tk.nextToken());

		int lx = 0, ly = 0, rx = 0, ry = 0;
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(br.readLine(), " ");

			lx = Integer.parseInt(tk.nextToken());
			ly = Integer.parseInt(tk.nextToken());
			rx = Integer.parseInt(tk.nextToken());
			ry = Integer.parseInt(tk.nextToken());
			for (int j = lx; j < rx; j++) {
				for (int k = y - ry; k < y - ly; k++) {
					check[j][k] = true;
				}
			}
		}
		int answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (check[i][j] == false) {
					q.add(dfs(i, j));
					answer++;
				}
			}
		}
		System.out.println(answer);
		for (int i = 0; i < answer; i++) {
			System.out.print(q.poll() + " ");
		}
	}

}
