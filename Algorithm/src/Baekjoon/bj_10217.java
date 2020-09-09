package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_10217 {

	static Queue<int[]>[] airports;
	static int N,M;
	static int answer=100000001;
	static boolean[] checkairport;
	
	//거리를 구하는 dfs
	public static void calcDistance(int airport,int pay,int time){
		checkairport[airport]=true;
		//거리와 비용이 만족할 때만 저장한다.
		if(pay<=M&&airport==N-1){
			answer=Math.min(answer, time);
		}else if(pay>M||time>answer){
			
		}else{
			int n=airports.length;
			for(int i=0;i<n;i++){
				int[] nowairport=airports[airport].poll();
				airports[airport].add(nowairport);
				if(checkairport[nowairport[0]]!=true){
				calcDistance(nowairport[0],pay+nowairport[1],time+nowairport[2]);
				}
			}
		}
		checkairport[airport]=false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++){

			StringTokenizer tk=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(tk.nextToken());
			M=Integer.parseInt(tk.nextToken());
			int K=Integer.parseInt(tk.nextToken());
			
			//Queue를 배열로 선언 및 초기화
			airports=new LinkedList[N];
			checkairport=new boolean[N];
			for(int j=0;j<N;j++){
				airports[j]=new LinkedList<>();
			}
			
			for(int j=0;j<K;j++){
				tk=new StringTokenizer(br.readLine()," ");
				int u=Integer.parseInt(tk.nextToken())-1;
				airports[u].add(new int[]{Integer.parseInt(tk.nextToken())-1,Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken())}); // 도착지, 비용, 소요시간			
			}	
			
			calcDistance(0,0,0);
			
			if(answer==100000001){
				System.out.println("Poor KCM");
			}else{
				System.out.println(answer);
			}
			
			//answer값 초기화
			answer=100000001;
		}

	}

}
