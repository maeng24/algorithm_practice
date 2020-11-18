package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_10164 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		int[][] answer = new int[N + 1][M + 1];

		int x = 0;
		int y = 0;
		// dp로 경로 구하기. 오른쪽과 아래로만 이동 가능하다.
		answer[0][1] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				answer[i][j] = answer[i][j - 1] + answer[i - 1][j];
				// 거쳐야하는 칸 위치 구하기
				if (((i - 1) * 5) + j == K) {
					x = j;
					y = i;
				}
			}
		}

		if(K==0){
			System.out.println(answer[N]);
		}else {
			System.out.println(answer[y][x] * answer[N - y + 1][M - x + 1]);
		}
	}

}
