package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1956 {

	static int V;
	static int[][] city;
	static boolean[] checkvisit;
	static final int MAX = 4000000;

	public static int findCycle() {
		//플로이드 와샬으로 경로 최솟값을 찾는다.
		for(int start=1;start<V+1;start++){
			for(int dest=1;dest<V+1;dest++){
				for(int visit=1;visit<V+1;visit++){
					if(city[start][dest]>city[start][visit]+city[visit][dest]){
						city[start][dest]=city[start][visit]+city[visit][dest];
					}
				}
			}
		}
		int answer=MAX;
		//최소 마을 사이클 찾기
		for(int i=1;i<V+1;i++){
			answer=Math.min(city[i][i], answer);
		}
		if(answer==MAX){
			return -1;
		}else{
			return answer;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(tk.nextToken());
		int E = Integer.parseInt(tk.nextToken());

		city = new int[V + 1][V + 1];
		//경로를 모두 최댓값으로 초기화
		for(int i=0;i<V+1;i++){
			for(int j=0;j<V+1;j++){
				city[i][j]=MAX;
			}
		}
		
		for (int i = 0; i < E; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			city[Integer.parseInt(tk.nextToken())][Integer.parseInt(tk.nextToken())] = Integer.parseInt(tk.nextToken());
			
		}
		
		System.out.println(findCycle());
	}

}
