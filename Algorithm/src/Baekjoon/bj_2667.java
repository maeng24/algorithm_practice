package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_2667 {

	static int num=0;
	static int[][] arr;
	static PriorityQueue<Integer> queue;
	static boolean[][] check;
	
	public static int dfs(int x, int y,int n) {
		n++;
		check[x][y]=true;
		if(y<arr[0].length-1&&arr[x][y+1]==1&&check[x][y+1]==false) {
			n=dfs(x,y+1,n);
		}
		if(x<arr.length-1&&arr[x+1][y]==1&&check[x+1][y]==false) {
			n=dfs(x+1,y,n);
		}
		if(y>0&&arr[x][y-1]==1&&check[x][y-1]==false) {
			n=dfs(x,y-1,n);
		}
		if(x>0&&arr[x-1][y]==1&&check[x-1][y]==false) {
			n=dfs(x-1,y,n);
		}
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		num=Integer.parseInt(br.readLine());
		arr=new int[num][num];
		
		for(int i=0;i<num;i++) {
			String temp = br.readLine();
            for(int j=0; j<num; j++){
                arr[i][j] = Integer.parseInt(temp.charAt(j)+"");
            }
		}
		
		check=new boolean[num][num];
		queue=new PriorityQueue<Integer>();
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				if(arr[i][j]==1&&!check[i][j]) {
					queue.add(dfs(i,j,0));	
				}
			}
		}
		System.out.println(queue.size());
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
