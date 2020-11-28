package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_1756 {
	
	static Stack<int[]> oven;
	static int[] doughs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int depth = Integer.parseInt(tk.nextToken());
		int dough = Integer.parseInt(tk.nextToken());

		oven = new Stack<>();// 피자를 넣을 오븐
		doughs = new int[dough];

		tk = new StringTokenizer(br.readLine(), " ");
		int min = Integer.parseInt(tk.nextToken());

		for (int i = 1; i < depth; i++) {
			int d = Integer.parseInt(tk.nextToken());
			if (d < min) {
				oven.push(new int[] { i - 1, min });// 해당 위치까지 min만큼의 반지름을 가진
													// 피자를 넣을 수 있다.
				min = d;
			}
		}
		if (oven.peek()[0] != depth - 1) {
			oven.push(new int[] { depth - 1, min });

		}
		tk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < dough; i++) {
			doughs[i] = Integer.parseInt(tk.nextToken());
		}

		int pos = oven.peek()[0];
		int rad = oven.pop()[1];
		int num = 0;

		while (num < dough) {
			if (doughs[num] > rad) {
				pos = oven.peek()[0];
				rad = oven.pop()[1];
			} else {

				if (!oven.isEmpty() && pos > oven.peek()[0]) {
					pos--;
					num++;
				} else if (oven.isEmpty() && pos >= 0) {
					pos--;
					num++;
				} else if (!oven.isEmpty()) {
					pos = oven.peek()[0];
					rad = oven.pop()[1];
				} else {
					break;
				}
			}
		}

		if (dough == num) {
			System.out.println(pos + 2);
		} else {
			System.out.println(0);
		}
	}

}
