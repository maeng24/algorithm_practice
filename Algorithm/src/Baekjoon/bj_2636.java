package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2636 {

	static int[][] cheese;
	static int remaincheese = 0;
	static int time = 0;
	static int ylen = 0, xlen = 0;
	static int[] xpos = { 1, 0, -1, 0 };
	static int[] ypos = { 0, 1, 0, -1 };

	// 몇 번에 걸쳐 녹는지 확인
	public static void meltcheese() {
		Queue<int[]> pos = new LinkedList<int[]>();
		pos.add(new int[] { 0, 0 });
		boolean[][] visit = new boolean[ylen][xlen];
		int cheeses = 0;

		while (!pos.isEmpty()) {
			int len = pos.size();
			for (int i = 0; i < len; i++) {
				int x = pos.peek()[0];
				int y = pos.poll()[1];
				if (!visit[y][x]) {
					visit[y][x] = true;
					for (int j = 0; j < 4; j++) {
						int nextx = x + xpos[j];
						int nexty = y + ypos[j];

						if (nextx >= 0 && nextx < xlen && nexty >= 0 && nexty < ylen && !visit[nexty][nextx]) {
							if (cheese[nexty][nextx] == 1) {
								visit[nexty][nextx] = true;
								cheese[nexty][nextx] = 0;
								cheeses++;
							} else {
								pos.add(new int[] { nextx, nexty });
							}
						}
					}
				}
			}
		}
		if (cheeses == 0) {
		} else {
			remaincheese = cheeses;
			time++;
			meltcheese();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		ylen = Integer.parseInt(tk.nextToken());
		xlen = Integer.parseInt(tk.nextToken());
		cheese = new int[ylen][xlen];

		for (int i = 0; i < ylen; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < xlen; j++) {
				cheese[i][j] = Integer.parseInt(tk.nextToken());
			}
		}

		// 바깥 쪽을 기준으로 순회한다.
		meltcheese();
		System.out.println(time + "\n" + remaincheese);

	}
}
