package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1976 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int travel=Integer.parseInt(br.readLine());
		
		int[][] road=new int[num][num];
		
		for(int i=0;i<num;i++){
			StringTokenizer tk=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<num;j++){
				road[i][j]=Integer.parseInt(tk.nextToken());
				
			}
		}
		
		//플로이드 와샬로 경로 체크
		for(int i=0;i<num;i++){
			for(int j=0;j<num;j++){
				for(int k=0;k<num;k++){
					if(road[i][k]==1&&road[k][j]==1){
						road[i][j]=1;
						road[j][i]=1;
					}
				}
				if(i==j){
					road[i][j]=1;
				}
			}
		}
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		int start=Integer.parseInt(tk.nextToken())-1;
		
		for(int j=1;j<travel;j++){
			int end=Integer.parseInt(tk.nextToken())-1;
			if(road[start][end]==0){
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
		
	}

}
