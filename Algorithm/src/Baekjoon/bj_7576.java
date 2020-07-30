package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_7576 {
	static int[] mov_x = { 1, 0, -1, 0 };
	static int[] mov_y = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] check;
	static int tomato;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int m, n, answer;

	//토마토  bfs
	public static void bfs() {
		while (!queue.isEmpty()) {
			
			int num = queue.size();
			
			for (int i = 0; i < num; i++) {
				int[] tmt = queue.poll();
				// 위 아래 양옆이 다 썩는다.
				for (int j = 0; j < 4; j++) {
					int y = tmt[0] + mov_y[j];
					int x = tmt[1] + mov_x[j];
					if (y < m && y >= 0 && x < n && x >= 0) {
						if (arr[y][x] == 0 && check[y][x] == false) {
							check[y][x] = true;
							tomato--;
							queue.add(new int[] { y, x });
						}
					}
					//남은 토마토가 없으면 break
					if (tomato == 0) {
						break;
					}
				}
				if (tomato == 0) {
					break;
				}
			}
			answer++;
			if (tomato == 0) {
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(tk.nextToken());
		m = Integer.parseInt(tk.nextToken());

		arr = new int[m][n];
		check = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
				if (arr[i][j] == 0) {
					tomato++;
				} else {
					check[i][j] = true;
					if (arr[i][j] == 1) {
						queue.add(new int[] { i, j });
					}
				}
			}
		}
		//멀쩡한 토마토가 들어있지 않으면  0을 출력, 아니면 bfs
		if (tomato == 0) {
			System.out.println(0);
		} else {
			bfs();

			if (tomato > 0) {
				System.out.println(-1);
			} else {
				System.out.println(answer);
			}
		}
	}
}