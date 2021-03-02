package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1967 {

	static ArrayList<int[]>[] tree;

	//dfs로 거리를 계산한다.
	public static int dfs(int index, int dis) {
		if (tree[index].size() == 0) {
			return dis;
		} else if (dis == 0) {
			//binary tree가 아닐 수 있으므로 가장 가중치가 높은 2개를 확인해야 한다.
			PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
			int len = tree[index].size();
			for (int i = 0; i < len; i++) {
				pqueue.add(dfs(tree[index].get(i)[0], tree[index].get(i)[1]));
			}
			//자식노드 갯수에 따른 리턴
			if (pqueue.size() > 1) {
				return pqueue.poll() + pqueue.poll();
			} else if (pqueue.size() == 1) {
				return pqueue.poll();
			} else {
				return 0;
			}

		} else {//이미 한 번 이상 연결되어 재귀하고 있는 경우
			int max = 0;
			int len = tree[index].size();
			for (int i = 0; i < len; i++) {
				max = Math.max(max, dfs(tree[index].get(i)[0], dis + tree[index].get(i)[1]));
			}
			return max;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		tree = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		n -= 1;
		StringTokenizer tk = null;
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			tree[Integer.parseInt(tk.nextToken())]
					.add(new int[] { Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken()) });
		}
		
		int answer = 0;
		n += 1;
		for (int i = 0; i <= n; i++) {
			answer = Math.max(answer, dfs(i, 0));
		}

		System.out.println(answer);
	}

}
