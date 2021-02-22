package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_11559 {
	static char[][] puyo;
	static boolean[][] visit;
	static int[] movex = { 1, 0, -1, 0 };
	static int[] movey = { 0, 1, 0, -1 };

	// 뿌요뿌요 연쇄 체크
	public static int puyo_check() {
		boolean puyopop = true;
		int cnt = 0;

		while (puyopop) {
			puyopop = false;

			visit = new boolean[12][6];
			// bfs로 터질수 있는 뿌요뿌요를 모두 터뜨린다.
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (puyo[i][j] != '.' && !visit[i][j]) {
						visit[i][j] = true;
						if (puyo_bfs(i, j)) {
							puyopop = true;
						}
					}
				}
			}

			if (puyopop) {
				// 터진 뿌요뿌요가 있다면 아래로 내린다.
				cnt++;
				downpuyo();
			}
		}
		return cnt;
	}

	public static boolean puyo_bfs(int y, int x) {
		int cnt = 0;
		Queue<int[]> puyos = new LinkedList<int[]>();
		Queue<int[]> pops = new LinkedList<int[]>();
		puyos.add(new int[] { y, x });
		pops.add(new int[] { y, x });
		int nexty = 0, nextx = 0;

		while (!puyos.isEmpty()) {
			int len = puyos.size();

			for (int i = 0; i < len; i++) {
				cnt++;
				y = puyos.peek()[0];
				x = puyos.poll()[1];

				for (int j = 0; j < 4; j++) {
					nexty = y + movey[j];
					nextx = x + movex[j];

					if (nexty >= 0 && nexty < 12 && nextx >= 0 && nextx < 6 && !visit[nexty][nextx]
							&& puyo[y][x] == puyo[nexty][nextx]) {
						visit[nexty][nextx] = true;
						puyos.add(new int[] { nexty, nextx });
						pops.add(new int[] { nexty, nextx });
					}
				}
			}
		}

		if (cnt >= 4) {
			while (!pops.isEmpty()) {
				puyo[pops.peek()[0]][pops.poll()[1]] = '.';
			}
			return true;
		}
		return false;
	}

	public static void downpuyo() {

		for (int j = 0; j < 6; j++) {
			int empty = -1;
			for (int i = 11; i >= 0; i--) {
				if (puyo[i][j] != '.' && empty != -1) {
					for (int k = i; k >= 0; k--) {
						if (puyo[k][j] != '.') {
							puyo[empty][j] = puyo[k][j];
							puyo[k][j] = '.';
							empty--;
						} else {
							break;
						}
					}
					break;
				}
				
				if (puyo[i][j] == '.' && empty < i) {
					empty = i;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		puyo = new char[12][6];
		for (int i = 0; i < 12; i++) {
			puyo[i] = br.readLine().toCharArray();
		}

		System.out.println(puyo_check());
	}

}
