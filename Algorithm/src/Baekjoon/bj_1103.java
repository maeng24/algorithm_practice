package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1103 {
	static int n, m;
	static int[][] board;
	static int[][] visit;
	static int[][] move = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static int findpath(int x, int y, int depth) {
		int answer = 0, checkans = 0;
		// 조건에 맞지 않으면 무한, 또는 깊이를 리턴
		if (visit[y][x] == -1) {
			return -1;
		} else if (board[y][x] == -1) {
			return depth;
		} else {
			visit[y][x] = -1;
			for (int i = 0; i < 4; i++) {
				int nextx = x + (board[y][x] * move[i][0]);
				int nexty = y + (board[y][x] * move[i][1]);

				if (nexty >= n || nextx >= m || nexty < 0 || nextx < 0) {
					answer = Math.max(depth + 1, answer);
				} else if (visit[nexty][nextx] <= 0) {
					checkans = findpath(nextx, nexty, depth + 1);
				} else {
					checkans = depth + visit[nexty][nextx] + 1;
				}
				if (checkans == -1) {// 무한이 나오면 즉시 무한만 리턴
					return -1;
				} else {
					answer = Math.max(answer, checkans);
				}
			}
			visit[y][x] = Math.max(visit[y][x], answer - depth); // 이 깊이로부터 더
																	// 깊이갈 수 있는
																	// 최대 깊이를 저장
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(tk.nextToken());
		m = Integer.parseInt(tk.nextToken());

		board = new int[n][m];
		visit = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				if (!str.substring(j, j + 1).equals("H")) {
					board[i][j] = Integer.parseInt(str.substring(j, j + 1));
				} else {// 구멍인 경우엔 -1을 넣는다.
					board[i][j] = -1;
				}
			}
		}

		int answer = findpath(0, 0, 0);
		
		System.out.println(answer);

	}

}
