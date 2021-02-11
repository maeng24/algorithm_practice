package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		int[] distance=new int[num-1];
		int[] cost=new int[num];
		
		//거리와 기름값 입력
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		for(int i=0,j=num-1;i<j;i++){
			distance[i]=Integer.parseInt(tk.nextToken());
		}
		
		tk=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<num;i++){
			cost[i]=Integer.parseInt(tk.nextToken());
		}
		
		
		int c=1000000001;
		long answer=0;
		
		//계산
		for(int i=0,j=num-1;i<j;i++){
			if(cost[i]<c){//다음 구간의 기름값이 전 기름값 보다 싸면 갱신
				c=cost[i];
			}
				answer+=(long)c*distance[i];
		}
		System.out.println(answer);
	}

}
