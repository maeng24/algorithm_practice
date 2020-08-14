package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1476 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// E15 S28 M19
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		int E = Integer.parseInt(tk.nextToken());
		int S = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		int e = 0, s = 0, m = 0;
		int cnt = 0;

		while (E != e || S != s || M != m) {
			if (e >= 15) {
				e = 0;
			}
			if (s >= 28) {
				s = 0;
			}
			if (m >= 19) {
				m = 0;
			}
			e++;
			s++;
			m++;
			cnt++;
		}
		System.out.println(cnt);
	}

}
