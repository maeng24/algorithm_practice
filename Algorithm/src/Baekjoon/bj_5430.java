package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class bj_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<String> deque = new LinkedList<String>();
		boolean reverse, error = false;
		char[] command = null;

		int comlen = 0;
		int arrlen = 0;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			reverse = false;
			error = false;
			command = br.readLine().toCharArray();
			comlen = command.length;
			arrlen = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			int strlen = str.length();
			str = str.substring(1, strlen - 1);
			String[] arr = str.trim().split(",");
			
			//배열이 비어있을 경우 deque도 비운다
			if (arr[0].equals("")) {
				deque.clear();
			} else {
				for (String s : arr) {
					deque.add(s);
				}
			}
			
			for (int j = 0; j < comlen; j++) {
				if (command[j] == 'R') {
					if (reverse) {
						reverse = false;
					} else {
						reverse = true;
					}
				} else if (command[j] == 'D') {
					if (deque.isEmpty()) {//비어있는 deque를 삭제하면 에러
						error = true;
						break;
					} else if (reverse) {
						deque.pollLast();
					} else {
						deque.pollFirst();
					}
				}
			}

			if (error) {
				System.out.println("error");
			} else if (deque.isEmpty()) {
				System.out.println("[]");
			} else {
				bw.append('[');
				if (reverse) {//뒤집어졌는지 확인 후 순서에 맞추기
					bw.append(deque.pollLast());
					while (!deque.isEmpty()) {
						bw.append(',' + deque.pollLast());
					}
				} else {
					bw.append(deque.pollFirst());
					while (!deque.isEmpty()) {
						bw.append(',' + deque.pollFirst());
					}
				}
				bw.append(']' + "\n");
				bw.flush();
			}

		}
	}

}
