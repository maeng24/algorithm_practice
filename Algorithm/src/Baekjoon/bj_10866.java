package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		Deque<Integer> dq=new LinkedList<>();
		StringTokenizer tk=null;
		
		//
		for (int i = 0; i < num; i++) {
			tk=new StringTokenizer(br.readLine());
			String str=tk.nextToken();
			if (str == "push_front") {
				int n=Integer.parseInt(tk.nextToken());
				dq.addFirst(n);
			}
			else if (str == "push_back") {
				int n=Integer.parseInt(tk.nextToken());
				dq.addLast(n);
			}
			else if (str == "pop_front") {
				if (dq.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(dq.pollFirst());
				}
			}
			else if (str == "pop_back") {
				if (dq.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(dq.pollLast());
				}
			}
			else if (str == "size") {
				System.out.println(dq.size());
			}
			else if (str == "empty") {
				if (dq.isEmpty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else if (str == "front") {
				if (dq.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(dq.peekFirst());
				}
			}
			else if (str == "back") {
				if (dq.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(dq.peekLast());
				}
			}
		}
	}

}
