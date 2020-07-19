package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1707 {
	// bfs�� ���� �˻��ϱ�
	public static boolean checkBipartite(ArrayList<Integer>[] graph) {

		int len = graph.length;
		Queue<Integer> point = new LinkedList<Integer>();
		int[] check = new int[len];
		
		//�׷��� ���� �˻�
		for (int i = 1; i < len; i++) {
			if (check[i] == 0) {
				check[i] = 1;
				point.add(i);
				
				//bfs�� �湮���� ���� �������� �湮������ ������ �湮
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

	//�����Լ�
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		while (num-- > 0) {
			
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(tk.nextToken());
			int E = Integer.parseInt(tk.nextToken());
			ArrayList<Integer>[] graph = new ArrayList[V + 1];
			
			// �ʱ�ȭ
			for (int i = 0; i < V + 1; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			
			// �׷��� ���� ����
			for (int i = 0; i < E; i++) {
				tk = new StringTokenizer(br.readLine(), " ");
				int firstpoint = Integer.parseInt(tk.nextToken());
				int secondpoint = Integer.parseInt(tk.nextToken());

				graph[firstpoint].add(secondpoint);
				graph[secondpoint].add(firstpoint);
			}

			// �̺� �׷��� �˻�
			if (checkBipartite(graph)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
