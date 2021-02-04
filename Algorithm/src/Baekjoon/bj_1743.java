package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1743 {

	static int N, M, K, answer;
	static boolean[][] map, visit;
	static int[] xpos = { 1, 0, -1, 0 };
	static int[] ypos = { 0, 1, 0, -1 };

	// 음식물의 크기를 확인하는 bfs
	public static void bfs(int y, int x, int size) {
		Queue<int[]> pos = new LinkedList<int[]>();
		pos.add(new int[] { y, x });
		int nextx = 0, nexty = 0;
		while (!pos.isEmpty()) {
			int len = pos.size();
			for (int i = 0; i < len; i++) {
				y = pos.peek()[0];
				x = pos.poll()[1];
				for (int j = 0; j < 4; j++) {
					nexty = y + ypos[j];
					nextx = x + xpos[j];
					if (nextx >= 0 && nexty >= 0 && nextx < M && nexty < N && map[nexty][nextx]
							&& !visit[nexty][nextx]) {
						pos.add(new int[] { nexty, nextx });
						visit[nexty][nextx] = true;
						size++;
					}
				}
			}
		}

		answer = Math.max(answer, size);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken());

		map = new boolean[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < K; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(tk.nextToken()) - 1][Integer.parseInt(tk.nextToken()) - 1] = true;
		}

		answer = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] && !visit[i][j]) {
					visit[i][j]=true;
					bfs(i, j, 1);
				}
			}
		}

		System.out.println(answer);
	}

}
