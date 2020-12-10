package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1780 {

	static int[][] paper;
	static int num;
	static int[] answer;

	// 해당 페이지가 모두 같은 수로 채워졌는지 확인
	public static boolean checksame(int n, int x, int y) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (paper[y][x] != paper[y + i][x + j]) {
					return false;
				}
			}
		}
		return true;
	}

	// 페이지를 자르거나 센다.
	public static void checkpaper(int n, int x, int y) {
		if (checksame(n, x, y)) {
			if (paper[y][x] == -1) {
				answer[0]++;
			} else if (paper[y][x] == 0) {
				answer[1]++;
			} else {
				answer[2]++;
			}
		} else {
			int cutn = n / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					checkpaper(cutn, x + (i * cutn), y + (j * cutn));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		paper = new int[num][num];
		answer = new int[3];

		StringTokenizer tk = null;

		for (int i = 0; i < num; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < num; j++) {
				paper[i][j] = Integer.parseInt(tk.nextToken());
			}
		}

		checkpaper(num, 0, 0);

		for (int i = 0; i < 3; i++) {
			System.out.println(answer[i]);
		}

	}

}
