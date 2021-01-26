package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_5014 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int F = Integer.parseInt(tk.nextToken());
		int S = Integer.parseInt(tk.nextToken());
		int G = Integer.parseInt(tk.nextToken());
		int U = Integer.parseInt(tk.nextToken());
		int D = Integer.parseInt(tk.nextToken());

		int[] building = new int[F+1];
		boolean[] visit = new boolean[F+1];

		Queue<Integer> curfloor = new LinkedList<Integer>();
		int count = 0, cur = 0;
		boolean success = false;
		
		curfloor.add(S);
		visit[S]=true;

		while (!curfloor.isEmpty()) {
			int len = curfloor.size();
			for (int i = 0; i < len; i++) {
				cur = curfloor.poll();
				if (cur == G) {
					success = true;
					break;
				} else {
					int next = cur + U;
					if (next<=F&&!visit[next]){
						visit[next]=true;
						curfloor.add(next);
					}
					next = cur - D;
					if (next>0&&!visit[next]){
						visit[next]=true;
						curfloor.add(next);
					}
				}
			}
			if (success) {
				break;
			}
			count++;
		}
		if(success){
			System.out.println(count);
		}else{
			System.out.println("use the stairs");
		}
	}

}
