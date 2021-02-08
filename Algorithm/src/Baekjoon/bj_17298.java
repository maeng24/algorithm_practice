package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_17298 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		int[] answer = new int[num];
		Stack<int[]> arrstack = new Stack<>();

		for (int i = 0; i < num; i++) {
			int n = Integer.parseInt(tk.nextToken());
			answer[i] = -1;
			// 오큰수를 만나면 해당 인덱스에 값을 저장한다.
			while (!arrstack.isEmpty() && arrstack.peek()[0] < n) {
				answer[arrstack.pop()[1]] = n;
			}
			// 현재 인덱스와 값을 스택에 넣는다.
			arrstack.add(new int[] { n, i });
		}

		for (int i : answer) {
			bw.append(i + " ");
		}
		bw.flush();
	}

}
