package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_1167 {
	public static ArrayList<int[]>[] tree;
	public static boolean[] visit;
	public static int[] result;

	public static void finddist(int start, int distance) {
		int len = tree[start].size();

		if (result[start] < distance) {
			result[start] = distance;
		}

		for (int i = 0; i < len; i++) {
			int dest = tree[start].get(i)[0];
			if (!visit[dest]) {
				visit[dest] = true;
				int dist = tree[start].get(i)[1] + distance;
				finddist(dest, dist);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V + 1];

		for (int i = 0; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < V; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(tk.nextToken());
			while (true) {
				int dest = Integer.parseInt(tk.nextToken());
				if (dest == -1) {
					break;
				}
				int dist = Integer.parseInt(tk.nextToken());
				tree[start].add(new int[] { dest, dist });
			}
		}

		// 한 정점에서 가장 먼 정점을 먼저 구한다.
		visit = new boolean[V + 1];
		result = new int[V + 1];
		visit[1] = true;
		finddist(1, 0);

		int max = 0;
		int index = 0;
		for (int i = 1; i <= V; i++) {
			if (max < result[i]) {
				max = result[i];
				index = i;
			}
		}

		visit = new boolean[V + 1];
		result = new int[V + 1];
		visit[index]=true;
		finddist(index,0);
		max=0;
		for (int i = 1; i <= V; i++) {
			if (max < result[i]) {
				max = result[i];
			}
		}
		System.out.println(max);
	}

}

