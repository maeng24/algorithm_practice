package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_7562 {

	static int[][] mov = { { 2, 1 }, { 2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { -2, 1 }, { -2, -1 } };
	static int[][] arr;
	static boolean[][] check;
	static Queue<int[][]> queue;
	static int[] finishpoint;
	
	//bfs로 나이트의 위치를 찾는다.
	public static int bfs() {
		int num=0;
		while (!queue.isEmpty()) {
			int queuesize = queue.size();
			for (int i = 0; i < queuesize; i++) {
				int[][] point = queue.poll();
				if(finishpoint[0]==point[0][0]&&finishpoint[1]==point[0][1]){
					return num;
				}
				for (int j = 0; j < mov.length; j++) {
					int x = point[0][0]+mov[j][0];
					int y = point[0][1]+mov[j][1];
					
					if(x>=0&&x<arr.length&&y>=0&&y<arr.length){
						if(check[x][y]==false){
							queue.add(new int[][]{{x,y}});
							check[x][y]=true;
						}
					}
				}
			}
			num++;
		}
		return -1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		for (int i = 0; i < test; i++) {

			int l = Integer.parseInt(br.readLine());
			arr = new int[l][l];
			check=new boolean[l][l];
			
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			int startpoint_x=Integer.parseInt(tk.nextToken());
			int startpoint_y=Integer.parseInt(tk.nextToken());
			
			queue=new LinkedList<int[][]>();
			queue.add(new int[][]{{startpoint_x,startpoint_y}});
			check[startpoint_x][startpoint_y]=true;
			
			tk = new StringTokenizer(br.readLine(), " ");
			finishpoint = new int[] { Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken()) };
			
			System.out.println(bfs());
		}
	}
}
