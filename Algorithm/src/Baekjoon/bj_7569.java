package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//이전에 풀었음
public class bj_7569 {

	static int x, y, z;
	static int[][][] arr;
	static boolean[][][] check;
	static int[] xx = { 1, 0, 0, -1, 0, 0 };
	static int[] yy = { 0, 1, 0, 0, -1, 0 };
	static int[] zz = { 0, 0, 1, 0, 0, -1 };
	static int tomato = 0;
	static int ripe_tomato = 0;
	static Queue<int[]> queue = new LinkedList<int[]>();

	public static int bfs() {
		int ans = -1;
		while (!queue.isEmpty()) {
			int n = queue.size();
			ans++;
			for (int j = 0; j < n; j++) {
				int[] tmp = queue.poll();
				for (int i = 0; i < 6; i++) {
					int mov_x = tmp[0] + xx[i];
					int mov_y = tmp[1] + yy[i];
					int mov_z = tmp[2] + zz[i];
					if (mov_x >= 0 && mov_x < x && mov_y >= 0 && mov_y < y && mov_z >= 0 && mov_z < z) {
						if ((!check[mov_x][mov_y][mov_z]) && arr[mov_x][mov_y][mov_z] == 0) {
							check[mov_x][mov_y][mov_z] = true;
							arr[mov_x][mov_y][mov_z] = 1;
							int[] qq = { mov_x, mov_y, mov_z };
							queue.add(qq);
							ripe_tomato++;
						}
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(tk.nextToken());
		y = Integer.parseInt(tk.nextToken());
		z = Integer.parseInt(tk.nextToken());

		arr = new int[x][y][z];
		check = new boolean[x][y][z];

		for (int i = 0; i < z; i++) {
			for (int j = 0; j < y; j++) {
				StringTokenizer token = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < x; k++) {
					int tom = Integer.parseInt(token.nextToken());
					arr[k][j][i] = tom;
					if (tom == 1 || tom == 0) {
						tomato++;
					}
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < z; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < x; k++) {
					if (!check[k][j][i] && arr[k][j][i] == 1) {
						int[] q = { k, j, i };
						queue.add(q);
						ripe_tomato++;
						check[k][j][i] = true;
					}
				}
			}
		}
		answer = bfs();
		if (ripe_tomato == tomato) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}
}
