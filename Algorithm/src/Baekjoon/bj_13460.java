package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_13460 {
	static int x, y;
	static char[][] arr;
	static Queue<int[]> r_queue;
	static Queue<int[]> b_queue;
	static int[] xx = { 1, 0, -1, 0 };
	static int[] yy = { 0, 1, 0, -1 };
	static int[] goal;
	static boolean[][][][] check;
	
	//옛날에 풀었음.. 나중에 다시 주석을 달아야 하는 문제.
	//bfs로 구슬이 갈 수 있는 곳을 구하여 queue에 넣는다.
	public static int bfs() {
		int ans = 0;
		while (!r_queue.isEmpty()) {
			int num = r_queue.size();
			ans += 1;
			for (int i = 0; i < num; i++) {
				int[] r = r_queue.poll();
				int[] b = b_queue.poll();
				check[r[0]][r[1]][b[0]][b[1]] = true;
				for (int j = 0; j < 4; j++) {
					boolean meet_b = false;
					boolean meet_r = false;
					boolean r_goal = false;
					boolean b_goal = false;
					int rx = r[0];
					int ry = r[1];
					int bx = b[0];
					int by = b[1];
					while (true) {
						rx += xx[j];
						ry += yy[j];
						if (rx == b[0] && ry == b[1]) {
							meet_b = true;
						} else if (arr[rx][ry] == 'O') {
							r_goal = true;
							break;
						} else if (arr[rx][ry] == '#') {
							rx -= xx[j];
							ry -= yy[j];
							break;
						}
					}
					if (r_goal == true && b_goal == false) {
						return ans;
					}
					while (true) {
						bx += xx[j];
						by += yy[j];
						if (bx == r[0] && by == r[1]) {
							meet_r = true;
						} else if (arr[bx][by] == 'O') {
							b_goal = true;
							break;
						} else if (arr[bx][by] == '#') {
							bx -= xx[j];
							by -= yy[j];
							break;
						}
					}
					if (meet_b == true) {
						rx -= xx[j];
						ry -= yy[j];
					}
					if (meet_r == true) {
						bx -= xx[j];
						by -= yy[j];
					}

					 else if (r_goal == false && b_goal == false) {
						if (check[rx][ry][bx][by] == false) {
							int[] ar = new int[] { rx, ry };
							int[] ab = new int[] { bx, by };
							r_queue.add(ar);
							b_queue.add(ab);
						}
					}
				}
			}

			if (ans == 10) {
				break;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		y = Integer.parseInt(tk.nextToken());
		x = Integer.parseInt(tk.nextToken());

		r_queue = new LinkedList<int[]>();
		b_queue = new LinkedList<int[]>();
		check = new boolean[x][y][x][y];
		arr = new char[x][y];

		for (int i = 0; i < y; i++) {
			String str = br.readLine();
			for (int j = 0; j < x; j++) {
				arr[j][i] = str.charAt(j);
				if (arr[j][i] == 'R') {
					int[] rr = { j, i };
					r_queue.add(rr);
				} else if (arr[j][i] == 'B') {
					int[] rr = { j, i };
					b_queue.add(rr);
				} else if (arr[j][i] == 'O') {
					goal = new int[] { j, i };
				}
			}
		}
		System.out.println(bfs());
	}
}
