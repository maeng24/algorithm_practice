package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		int n = 0, answer = 0;
		boolean primenum = false;
		for (int i = 0; i < num; i++) {
			n = Integer.parseInt(tk.nextToken());
			//n이 1보다 클때만 계산
			if (n > 1) {
				primenum = true;
			}
			//소수인지 아닌지 판별한다.
			for (int j = 2, k = n / 2 + 1; j < k; j++) {
				if (n % j == 0) {
					primenum = false;
					break;
				}
			}
			if (primenum) {
				answer++;
			}
		}
		System.out.println(answer);

	}

}
