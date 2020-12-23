package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1915 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());

		int[][] answer = new int[n+1][m+1];

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++) {
				answer[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}

		int max = 0;
		
		//dp로 정사각형 찾기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (answer[i][j] != 0) {
					answer[i][j] += Math.min(answer[i - 1][j - 1], Math.min(answer[i][j - 1], answer[i - 1][j]));
				}
				max = Math.max(max, answer[i][j]);
			}
		}

		System.out.println(max*max);
	}

}
