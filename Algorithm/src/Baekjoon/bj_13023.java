package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_13023 {

	static int N;
	static ArrayList<Integer>[] friends;
	static boolean[] visit;

	public static int dfs(int index, int depth) {
		if (depth == 5) {
			return 1;
		} else {
			visit[index] = true;
			int len=friends[index].size();
			for (int i = 0; i < len; i++) {
				if (!visit[friends[index].get(i)]) {
					if (dfs(friends[index].get(i), depth + 1) == 1) {
						return 1;
					}
				}
			}
			visit[index] = false;
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());

		friends=new ArrayList[N];
		for (int i = 0; i < N; i++) {
			friends[i] = new ArrayList<>();
		}
		
		visit = new boolean[N];
		int s = 0, e = 0;
		for (int i = 0; i < m; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(tk.nextToken());
			e = Integer.parseInt(tk.nextToken());
			friends[s].add(e);
			friends[e].add(s);
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (dfs(i, 1) == 1) {
				answer = 1;
				break;
			}
		}
		System.out.println(answer);
	}

}
