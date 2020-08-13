package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2573 {

	static int[][] glaciers;
	static Queue<int[]> glacier;
	static int height;
	static int width;
	static int[] xpos = { 0, 1, 0, -1 };
	static int[] ypos = { 1, 0, -1, 0 };

	// 빙하 덩어리의 갯수를 세는 메서드
	public static int glacierNum() {
		int glanum = glacier.size();
		boolean[][] check = new boolean[height][width];
		int ans = 0;
		if (!glacier.isEmpty()) {
			for (int i = 0; i < glanum; i++) {
				int h = glacier.peek()[0];
				int w = glacier.poll()[1];

				if (!check[h][w]) {
					check = dfs(h, w, check);
					ans++;
					if (ans > 1) {
						return ans;
					}
				}
				glacier.add(new int[] { h, w });
			}
		}

		return ans;
	}

	// dfs로 이어진 빙하 덩어리를 체크하는 메서드
	public static boolean[][] dfs(int h, int w, boolean[][] check) {
		check[h][w] = true;
		for (int k = 0; k < 4; k++) {
			int nexth = h + ypos[k];
			int nextw = w + xpos[k];
			if (nexth >= 0 && nextw >= 0 && nexth < height && nextw < width && glaciers[nexth][nextw] != 0
					&& !check[nexth][nextw]) {
				check = dfs(nexth, nextw, check);
			}
		}
		return check;
	}

	// 빙하가 녹는 메서드
	public static int melting() {
		int glaciernum = glacierNum();
		int answer = 0;

		while (glaciernum != 0) {
			int[][] meltglaciers = new int[height][width];
			int glanum = glacier.size();
			for (int i = 0; i < glanum; i++) {
				int h = glacier.peek()[0];
				int w = glacier.poll()[1];
				int melth = 0;
				
				for (int j = 0; j < 4; j++) {
					int nexth = h + xpos[j];
					int nextw = w + ypos[j];
					if (nexth >= 0 && nextw >= 0 && nexth < height && nextw < width && glaciers[nexth][nextw] == 0) {
						melth++;
					}
				}
				
				meltglaciers[h][w] = glaciers[h][w] - melth;
				
				if (meltglaciers[h][w] < 0) {
					meltglaciers[h][w] = 0;
				} else if (meltglaciers[h][w] > 0) {
					glacier.add(new int[] { h, w });
				}
			}

			glaciers = meltglaciers;
			answer++;
			glaciernum = glacierNum();
			
			if (glaciernum > 1) {
				return answer;
			} else if (glaciernum == 0) {
				return 0;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		height = Integer.parseInt(tk.nextToken());
		width = Integer.parseInt(tk.nextToken());
		glaciers = new int[height][width];
		glacier = new LinkedList<int[]>();

		for (int i = 0; i < height; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < width; j++) {
				glaciers[i][j] = Integer.parseInt(tk.nextToken());
				if (glaciers[i][j] != 0) {
					glacier.add(new int[] { i, j });
				}
			}
		}
		
		System.out.println(melting());

	}

}
