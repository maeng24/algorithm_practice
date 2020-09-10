package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

	private int start;
	private int cost;
	private int dist;

	public Node(int start, int cost, int dist) {
		super();
		this.start = start;
		this.cost = cost;
		this.dist = dist;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

	@Override
	public int compareTo(Node o) {
		return this.dist - o.getDist();
	}

}

public class bj_10217 {

	static int N, M;
	static ArrayList<int[]>[] flights;
	static final int MAX = 100000001;

	// 거리를 구하는 Dijkstra
	public static void calcDistance(int start) {
		PriorityQueue<Node> airports = new PriorityQueue<>();
		airports.add(new Node(start, 0, 0));


		int[][] distance = new int[N][M + 2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= M + 1; j++) {
				distance[i][j] = MAX;
			}
		}
		distance[start][0] = 0;

		while (!airports.isEmpty()) {
			start = airports.peek().getStart();
			int currentdist = airports.peek().getDist();
			int cost = airports.poll().getCost();

			if (currentdist >= distance[start][cost]) {
				int len=flights[start].size();
				for(int i=0;i<len;i++){
					// dp를 이용한 cost에 따른 최단 거리 판별

					int nextdest=flights[start].get(i)[0];
					int nextcost = cost + flights[start].get(i)[1];
					int nextdist = currentdist + flights[start].get(i)[2];

					if (M >= nextcost && distance[nextdest][nextcost] > nextdist) {
						distance[nextdest][nextcost] = nextdist;
						airports.add(new Node(nextdest, nextcost, nextdist));
					}
				}
			}
		}
		
		int answer = MAX;
		for (int j = 0; j < M + 1; j++) {
			answer = Math.min(answer, distance[N - 1][j]);
		}

		if (answer == MAX) {
			System.out.println("Poor KCM");
		} else {
			System.out.println(answer);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(tk.nextToken());
			M = Integer.parseInt(tk.nextToken());
			int K = Integer.parseInt(tk.nextToken());

			flights = new ArrayList[N];
			for(int j=0;j<N;j++){
				flights[j]=new ArrayList<>();
			}

			for (int j = 0; j < K; j++) {
				tk=new StringTokenizer(br.readLine()," ");
				int u=Integer.parseInt(tk.nextToken())-1;
				flights[u].add(new int[]{Integer.parseInt(tk.nextToken())-1,Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken())}); // 도착지, 비용, 소요시간			
			}

			calcDistance(0);

		}

	}

}
