package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1520 {

	public static final int MAX = 500000;
	public static int[] movex = { 1, 0, -1, 0 };
	public static int[] movey = { 0, 1, 0, -1 };
	public static int[][] road;
	public static int[][] answer;
	public static boolean[][] visit;
	public static int x, y;

	//dfs+dp
	public static int checkroad(int ypos, int xpos) {
		
		if (ypos == y - 1 && xpos == x - 1) {//if 문을 쓰는 대신 맨 dp배열에 1을 저장해도 된다.
			return 1;
		} else {
			visit[ypos][xpos] = true;
			for (int i = 0; i < 4; i++) {
				int nexty = ypos + movey[i];
				int nextx = xpos + movex[i];
				if (nextx < x && nexty < y && nextx >= 0 && nexty >= 0 && road[ypos][xpos] > road[nexty][nextx]) {
					if (visit[nexty][nextx]) {//이미 방문한 곳은 재방문하지 않는다.
						answer[ypos][xpos] += answer[nexty][nextx];
					} else {
						answer[ypos][xpos] += checkroad(nexty, nextx);
					}
				}
			}
		}
		return answer[ypos][xpos];

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		y = Integer.parseInt(tk.nextToken());
		x = Integer.parseInt(tk.nextToken());
		road = new int[y][x];
		visit = new boolean[y][x];
		answer = new int[y + 1][x + 1];

		for (int i = 0; i < y; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < x; j++) {
				road[i][j] = Integer.parseInt(tk.nextToken());
			}
		}

		System.out.println(checkroad(0, 0));
		
	}

}
