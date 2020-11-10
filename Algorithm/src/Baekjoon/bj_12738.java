package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_12738 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());

		int number = 0;
		int[] answer = new int[len];

		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		int result = 1;
		answer[0] = Integer.parseInt(tk.nextToken());

		for (int i = 1; i < len; i++) {
			number = Integer.parseInt(tk.nextToken());
			if (answer[result - 1] < number) {
				answer[result] = number;
				result++;
			} else {
				for (int j = result - 2; j >= 0; j--) {
					if (answer[j] < number) {
						answer[j + 1] = number;
						break;
					}
				}
			}
		}

		System.out.println(result);
	}

}
