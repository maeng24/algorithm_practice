package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_3184 {
	static int x;
	static int y;
	static char[][] arr;
	static boolean[][] check;
	static int[] xx = { 1, 0, -1, 0 };
	static int[] yy = { 0, 1, 0, -1 };
	static int v, o;
	
	public static void bfs(int a, int b) {

		if (arr[a][b] != '#' && check[a][b] == false) {
			check[a][b] = true;
			if (arr[a][b] == 'v') {
				v++;
			} else if (arr[a][b] == 'o') {
				o++;
			}

			for (int i = 0; i < 4; i++) {
				int aa = a + xx[i];
				int bb = b + yy[i];
				if (aa >= 0 && aa < x && bb >= 0 && bb < y) {
					bfs(aa, bb);

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(tk.nextToken());
		y = Integer.parseInt(tk.nextToken());
		arr = new char[x][y];
		check = new boolean[x][y];

		for (int i = 0; i < x; i++) {
			String temp = br.readLine();
			for (int j = 0; j < y; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		int answer_o = 0;
		int answer_v = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				v = 0;
				o = 0;
				bfs(i, j);

				if (o > v) {
					answer_o += o;
				} else {

					answer_v += v;
				}

			}
		}
		System.out.println(answer_o + " " + answer_v);
	}

}
