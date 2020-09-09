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
	
	//�Ÿ��� ���ϴ� dfs
	public static void calcDistance(int airport,int pay,int time){
		checkairport[airport]=true;
		//�Ÿ��� ����� ������ ���� �����Ѵ�.
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
			
			//Queue�� �迭�� ���� �� �ʱ�ȭ
			airports=new LinkedList[N];
			checkairport=new boolean[N];
			for(int j=0;j<N;j++){
				airports[j]=new LinkedList<>();
			}
			
			for(int j=0;j<K;j++){
				tk=new StringTokenizer(br.readLine()," ");
				int u=Integer.parseInt(tk.nextToken())-1;
				airports[u].add(new int[]{Integer.parseInt(tk.nextToken())-1,Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken())}); // ������, ���, �ҿ�ð�			
			}	
			
			calcDistance(0,0,0);
			
			if(answer==100000001){
				System.out.println("Poor KCM");
			}else{
				System.out.println(answer);
			}
			
			//answer�� �ʱ�ȭ
			answer=100000001;
		}

	}

}
