package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer tk = null;
		String str = "";
		Deque<String> deque = new LinkedList<String>();

		for (int i = 0; i < num; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			str = tk.nextToken();
			if (str.equals("push")) {
				deque.add(tk.nextToken());
			} else if (str.equals("pop")) {
				if (deque.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(deque.poll() + "\n");
				}
			} else if (str.equals("front")) {
				if (deque.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(deque.getFirst() + "\n");
				}
			} else if (str.equals("back")) {
				if (deque.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(deque.getLast() + "\n");
				}
			} else if (str.equals("empty")) {
				if (deque.isEmpty()) {
					bw.append("1\n");
				} else {
					bw.append("0\n");
				}
			} else if (str.equals("size")) {
				bw.append(deque.size() + "\n");
			}

		}
		bw.flush();
	}

}
