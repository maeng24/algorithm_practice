package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1516 {

	static int num;
	static Queue<Integer> []buildings;
	static int[] time;
	
	public static void buildtime_dp(int index){
		while(!buildings[index].isEmpty()){
			int n=buildings[index].size();
			System.out.print(n+":");
			for(int i=0;i<n;i++){
				System.out.print(i+"/"+buildings[i].peek()+" ");
				int b=buildings[index].poll();
				if(!buildings[b].isEmpty()){
					buildtime_dp(b);
				}
				time[index]+=time[b];
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		num=Integer.parseInt(br.readLine());
		time=new int[num];
		buildings=new LinkedList[num];
		
		StringTokenizer tk=null;
		for(int i=0;i<num;i++){
			buildings[i]=new LinkedList<>();
			tk=new StringTokenizer(br.readLine()," ");
			time[i]=Integer.parseInt(tk.nextToken());
			int n=Integer.parseInt(tk.nextToken());
			
			while(n!=-1){
				buildings[i].add(n);
				n=Integer.parseInt(tk.nextToken());
			}
		}
		
		for(int i=0;i<num;i++){
			buildtime_dp(i);
		}
		
		for(int i=0;i<num;i++){
			System.out.println(time[i]);
		}
		
		
	}

}
