package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int number = 0;
		int[] prevmaxdp = new int[3];
		int[] nextmaxdp = new int[3];
		int[] prevmindp = new int[3];
		int[] nextmindp = new int[3];

		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		// 첫 줄만 초기값 지정
		for (int i = 0; i < 3; i++) {
			number = Integer.parseInt(tk.nextToken());
			prevmaxdp[i] = number;
			prevmindp[i] = number;
		}

		// dp구하기
		for (int i = 1; i < n; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				number = Integer.parseInt(tk.nextToken());

				if (j == 0) {
					nextmaxdp[j] = Math.max(prevmaxdp[j], prevmaxdp[j + 1]) + number;
					nextmindp[j] = Math.min(prevmindp[j], prevmindp[j + 1]) + number;
				} else if (j == 2) {
					
					nextmaxdp[j] = Math.max(prevmaxdp[j - 1], prevmaxdp[j]) + number;
					nextmindp[j] = Math.min(prevmindp[j - 1], prevmindp[j]) + number;
				} else {
					nextmaxdp[j] = Math.max(prevmaxdp[j - 1], Math.max(prevmaxdp[j], prevmaxdp[j + 1])) + number;
					nextmindp[j] = Math.min(prevmindp[j - 1], Math.min(prevmindp[j], prevmindp[j + 1])) + number;
				}

			}
			for (int j = 0; j < 3; j++) {
				prevmaxdp[j] = nextmaxdp[j];
				prevmindp[j] = nextmindp[j];
			}
		}
		int max = 0, min = 10000000;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, prevmaxdp[i]);
			min = Math.min(min, prevmindp[i]);
		}
		System.out.println(max + " " + min);

	}

}
