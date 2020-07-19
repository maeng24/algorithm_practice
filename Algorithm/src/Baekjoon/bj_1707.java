package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1707 {
	// bfs로 간선 검사하기
	public static boolean checkBipartite(ArrayList<Integer>[] graph) {

		int len = graph.length;
		Queue<Integer> point = new LinkedList<Integer>();
		int[] check = new int[len];
		
		//그래프 간선 검사
		for (int i = 1; i < len; i++) {
			if (check[i] == 0) {
				check[i] = 1;
				point.add(i);
				
				//bfs로 방문하지 않은 정점에서 방문가능한 정점을 방문
				while (!point.isEmpty()) {

					int now_p = point.poll();

					for (int j : graph[now_p]) {
						if (check[j] != 0) {
							if (check[now_p] == check[j]) {
								return false;
							}
						} else if (check[j] == 0) {
							if (check[now_p] == 1) {
								check[j] = 2;
								point.add(j);
							} else if (check[now_p] == 2) {
								check[j] = 1;
								point.add(j);
							}
						}
					}
				}
			}
		}
		return true;
	}

	//메인함수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		while (num-- > 0) {
			
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(tk.nextToken());
			int E = Integer.parseInt(tk.nextToken());
			ArrayList<Integer>[] graph = new ArrayList[V + 1];
			
			// 초기화
			for (int i = 0; i < V + 1; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			
			// 그래프 간선 저장
			for (int i = 0; i < E; i++) {
				tk = new StringTokenizer(br.readLine(), " ");
				int firstpoint = Integer.parseInt(tk.nextToken());
				int secondpoint = Integer.parseInt(tk.nextToken());

				graph[firstpoint].add(secondpoint);
				graph[secondpoint].add(firstpoint);
			}

			// 이분 그래프 검사
			if (checkBipartite(graph)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
