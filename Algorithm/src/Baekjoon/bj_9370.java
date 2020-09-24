package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node9370 implements Comparable<Node9370> {

	private int start;
	private int distance;

	public Node9370(int start, int distance) {
		super();
		this.start = start;
		this.distance = distance;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Node9370 o) {
		// TODO Auto-generated method stub
		return distance - o.getDistance();
	}

}

public class bj_9370 {
	static int n, m, t, s, g, h;
	static ArrayList<int[]>[] roads;
	static int[] mindistance;
	static int[] mindistancewithoutroad;
	static final int MAX=100000000;
	// 다익스트라를 이용해서 길을 찾는다.
	public static void findroad() {
		PriorityQueue<Node9370> minroad = new PriorityQueue<>();
		mindistance = new int[n + 1];
		Arrays.fill(mindistance, MAX);
		
		minroad.add(new Node9370(s, 0));
		
		while (!minroad.isEmpty()) {
			int start = minroad.peek().getStart();
			int distance = minroad.poll().getDistance();
			if (distance <= mindistance[start]) {
				int len = roads[start].size();
				for (int i = 0; i < len; i++) {
					int destination = roads[start].get(i)[0];
					int nextdistance = roads[start].get(i)[1] + distance;
					if (nextdistance < mindistance[destination]) {
						mindistance[destination] = nextdistance;
						minroad.add(new Node9370(destination, nextdistance));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < test; tc++) {
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(tk.nextToken());
			m = Integer.parseInt(tk.nextToken());
			t = Integer.parseInt(tk.nextToken());

			tk = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(tk.nextToken());
			g = Integer.parseInt(tk.nextToken());
			h = Integer.parseInt(tk.nextToken());

			roads = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				roads[i] = new ArrayList<>();
			}

			//g-h를 지나가는 경우에만 거리가 홀수가 되도록 설정.
			for (int i = 0; i < m; i++) {
				tk = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(tk.nextToken());
				int b = Integer.parseInt(tk.nextToken());
				int d = Integer.parseInt(tk.nextToken());
				if ((g == a && h == b) || (g == b && h == a)) {
					d=d*2-1;
				} else {
					d= d*2;
				}
				roads[a].add(new int[] { b, d });
				roads[b].add(new int[] { a, d });
			}

			// 최소 거리
			findroad();

			PriorityQueue<Integer> answers = new PriorityQueue<>();
			
			// 최소거리가 홀수인 것들만 고른 뒤 정렬
			for (int i = 0; i < t; i++) {
				int dest = Integer.parseInt(br.readLine());
				
				if (mindistance[dest]%2 ==1 ) {
					answers.add(dest);
				}
			}
			
			while(!answers.isEmpty()){
				System.out.print(answers.poll()+" ");
			}
			System.out.println();
		}
	}
}
