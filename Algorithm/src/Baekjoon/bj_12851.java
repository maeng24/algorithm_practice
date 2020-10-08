package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_12851 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		boolean[] visit=new boolean[200000];
		
		Queue<Integer> pos = new LinkedList<>();

		pos.add(N);
		visit[N]=true;
		int depth = 0;
		int count = 0;

		while (!pos.isEmpty()) {
			int len = pos.size();
			for (int i = 0; i < len; i++) {
				int point = pos.poll();
				visit[point]=true;
				if (point == K) {
					count++;
				}
				if (count == 0) {
					int nextpoint = point - 1;
					if (nextpoint >=0&&!visit[nextpoint]) {
						pos.add(nextpoint);
					}
					nextpoint = point + 1;
					if (nextpoint <= K&&!visit[nextpoint]) {
						pos.add(nextpoint);
					}
					nextpoint = 2 * point;
					if (nextpoint < 2 * K&&!visit[nextpoint]) {
						pos.add(nextpoint);
					}
				}
			}
			if(count>0){
				break;
			}
			depth++;
		}
		System.out.println(depth+"\n"+count);
	}
}

