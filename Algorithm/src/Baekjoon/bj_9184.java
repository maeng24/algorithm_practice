package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_9184 {

	static int[][][] arr = new int[21][21][21];

	public static int dp(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		} else if (a > 20 || b > 20 || c > 20) {
			return dp(20, 20, 20);
		} else if (a < b && b < c) {
			if (arr[a][b][c] == 0) {
				arr[a][b][c] = dp(a, b, c - 1) + dp(a, b - 1, c - 1) - dp(a, b - 1, c);
			}
			return arr[a][b][c];
		} else {
			if (arr[a][b][c] == 0) {
				arr[a][b][c] = dp(a - 1,b,c) + dp(a - 1,b - 1,c) + dp(a - 1,b,c - 1)
						- dp(a - 1,b - 1,c - 1);
			}
			return arr[a][b][c];
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = null;
		int a, b, c = 0;

		while (true) {
			tk = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(tk.nextToken());
			b = Integer.parseInt(tk.nextToken());
			c = Integer.parseInt(tk.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				break;
			} 
			
			bw.append("w("+a+", "+b+", "+c+") = "+dp(a,b,c)+"\n");
		}
		bw.flush();
	}

}
