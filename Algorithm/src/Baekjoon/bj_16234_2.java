package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16234_2 {
	static int N, L, R;
	static int[][] country, result;
	static boolean[][] visit;
	static int[] xpos = { 1, 0, -1, 0 };
	static int[] ypos = { 0, 1, 0, -1 };
	static int sum, number;
	static Queue<int[]> pos;
	static boolean differ;

	public static void move(int y, int x, int first) {
		visit[y][x] = true;
		sum += country[y][x];
		pos.add(new int[] { y, x });
		number++;
		//같은수의 국가들만 남았을 때 무한 반복 방지
		if (country[y][x] != first) {
			differ = true;
		}
		for (int k = 0; k < 4; k++) {
			int nextx = x + xpos[k];
			int nexty = y + ypos[k];
			
			if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N && !visit[nexty][nextx]) {
				//두 국가 인구수 차 구하기
				int dif = Math.abs(country[nexty][nextx] - country[y][x]);
				if (dif <= R && dif >= L) {
					move(nexty, nextx, first);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// bfs로 한번 연합을 싹 돈다
		// 같은수의 사람만을 가지고 있을 경우 연합을 만들지 말아야함
		// 연합이 하나도 만들어지지 않으면 반복문을 끝낸다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tk.nextToken());
		L = Integer.parseInt(tk.nextToken());
		R = Integer.parseInt(tk.nextToken());

		country = new int[N][N];

		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(tk.nextToken());
			}
		}

		int answer = 0;
		while (true) {
			visit = new boolean[N][N];
			boolean isunited = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						pos = new LinkedList<int[]>();
						sum = 0;
						number = 0;
						differ = false;
						move(i, j, country[i][j]);
						if (number > 1 && differ) {
							int pnum = sum / number;
							while (!pos.isEmpty()) {
								country[pos.peek()[0]][pos.poll()[1]] = pnum;
							}
							isunited = true;
						}
					}
				}
			}
			if (!isunited) {
				break;
			}
			answer++;
		}

		System.out.println(answer);
	}

}
