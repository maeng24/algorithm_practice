package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	private int start;
	private int distance;
	
	public Node(int start, int distance) {
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
	
}


public class bj_1956 {
	/*
	static int V;
	static ArrayList<int[]>[] city;
	static int[] checkvisit;
	static final int MAX=1600000000;
	
	public static void findCycle(int start){
		PriorityQueue<Node> cycles=new PriorityQueue<>();
		cycles.add(new Node(start, 0));
		int visit=0;
		int[] distances=new int[V+1];
		
		for(int i=0;i<V+1;i++){
			distances[i]=MAX;
		}
		distances[0]=0;
		
		while(!cycles.isEmpty()){
			int nowstart=cycles.peek().getStart();
			int nowdistance=cycles.poll().getDistance();
			
			if(nowdistance>=distances[nowstart]){
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		V=Integer.parseInt(tk.nextToken());
		int E=Integer.parseInt(tk.nextToken());
		
		city=new ArrayList[V+1];
		checkvisit=new int[V+1];
		for(int i=0;i<V+1;i++){
			city[i]=new ArrayList<>();
		}
		
		for(int i=0;i<E;i++){
			tk=new StringTokenizer(br.readLine()," ");
			city[Integer.parseInt(tk.nextToken())].add(new int[]{Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken())});
		}
		
		
		

	}
*/
}
