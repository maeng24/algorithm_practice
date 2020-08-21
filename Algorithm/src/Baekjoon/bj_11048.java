package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11048 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		int n=Integer.parseInt(tk.nextToken());
		int m=Integer.parseInt(tk.nextToken());
		int[][] maze=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++){
			tk=new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=m;j++){
				maze[i][j]=Integer.parseInt(tk.nextToken());
			}
		}
		
		//dp를 이용하여 maze의 도달한 칸에서 구할 수 있는 사탕의 최대 갯수를 저장한다.
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				maze[i][j]=Math.max(maze[i][j-1], maze[i-1][j])+maze[i][j];
			}
		}
		
		System.out.println(maze[n][m]);
	}

}
