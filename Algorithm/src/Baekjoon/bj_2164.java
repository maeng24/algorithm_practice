package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//C로 풀었던 문제
public class bj_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int num=Integer.parseInt(br.readLine());
			Queue<Integer> q=new LinkedList<Integer>();
			
			for (int i = 1; i <=num; i++) {
				q.add(i);
			}
			
			boolean flag=true;
			
			while (q.size() != 1) {
				if (flag) {
					q.poll();
					flag = false;
				}
				else {
					q.add(q.poll());
					
					flag = true;		
				}
			}
			System.out.println(q.peek());
		}

}
