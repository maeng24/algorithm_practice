package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node1753 implements Comparable<Node1753> {
	int end, weight;

	public Node1753(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node1753 o) { // 오름차순
		return weight - o.weight;
	}
}

public class bj_1753 {

	private static final int INF = Integer.MAX_VALUE;
	static List<Node1753>[] list;
	static int[] answer;

	private static void dijkstra(int start, int v) {
		PriorityQueue<Node1753> queue = new PriorityQueue()<>();
		boolean[] check = new boolean[v + 1];
		queue.add(new Node1753(start, 0));
		answer[start] = 0;

		while (!queue.isEmpty()) {
			Node1753 n = queue.poll();
			int index = n.end;

			if (check[index] == false) { // 방문하지 않은 경우
				for (Node1753 node : list[index]) {

					// 기존 가중치와 비교
					if (answer[index] + node.weight < answer[node.end]) {
						answer[node.end] = answer[index] + node.weight;
						queue.add(new Node1753(node.end, answer[node.end]));
					}
				}
			} else {
				check[index] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(tk.nextToken());
		int E = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		answer = new int[V + 1];

		Arrays.fill(answer, INF);

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			tk = new StringTokenizer(br.readLine(), " ");

			list[Integer.parseInt(tk.nextToken())]
					.add(new Node1753(Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken())));
		}

		// 다익스트라 알고리즘
		dijkstra(K, V);

		for (int i = 1; i <= V; i++) {
			if (answer[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(answer[i]);
			}
		}

	}

}
