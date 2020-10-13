package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1012 {
	static int[][] arr;
	static int num;
	static boolean[][] check;
	static int answer=0;
	
	public static void dfs(int x, int y) {
		check[x][y]=true;
		if(y<arr[0].length-1&&arr[x][y+1]==1&&check[x][y+1]==false) {
			dfs(x,y+1);
		}
		if(x<arr.length-1&&arr[x+1][y]==1&&check[x+1][y]==false) {
			dfs(x+1,y);
		}
		if(y>0&&arr[x][y-1]==1&&check[x][y-1]==false) {
			dfs(x,y-1);
		}
		if(x>0&&arr[x-1][y]==1&&check[x-1][y]==false) {
			dfs(x-1,y);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		num=Integer.parseInt(br.readLine());
		for(int i=0;i<num;i++) {
			StringTokenizer tk=new StringTokenizer(br.readLine(), " ");
			int x=Integer.parseInt(tk.nextToken());
			int y=Integer.parseInt(tk.nextToken());
			int seeds=Integer.parseInt(tk.nextToken());
			arr=new int[x][y];
			check=new boolean[x][y];
			
			for(int j=0;j<seeds;j++) {
				StringTokenizer token=new StringTokenizer(br.readLine(), " ");
				int xx=Integer.parseInt(token.nextToken());
				int yy=Integer.parseInt(token.nextToken());
				arr[xx][yy]=1;
			}
			
			for(int j=0;j<x;j++) {
				for(int k=0;k<y;k++) {
					if(arr[j][k]==1&&check[j][k]==false) {
						dfs(j,k);
						answer++;
					}
				}
			}
			System.out.println(answer);
			answer=0;
		}
	}
}
