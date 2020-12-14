package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2589 {
	static int x = 0, y = 0;
	static char[][] arr;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int bfs(int a,int b) {
		Queue<int[]> q=new LinkedList<int[]>();
		boolean[][] check=new boolean[50][50];
		q.add(new int[]{a, b});
		int ans = 0;
		while (!q.isEmpty()) {
			int n = q.size();
			for (int j = 0; j < n; j++) {
				int tx = q.peek()[1];
				int ty = q.poll()[0];
				check[ty][tx] = true;
				for (int i = 0; i < 4; i++) {
					int mov_x = tx + dx[i];
					int mov_y = ty + dy[i];
					if (mov_x >= 0 && mov_x < x && mov_y >= 0 && mov_y < y && arr[mov_y][mov_x] != 'W' && check[mov_y][mov_x] == false) {
						check[mov_y][mov_x] = true;
						q.add(new int[]{mov_y,mov_x});
					}
				}
				
			}
			ans++;
		}
		return ans-1;
	}

	public static void main(String[] args) throws IOException {
		arr=new char[50][50];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		y=Integer.parseInt(tk.nextToken());
		x=Integer.parseInt(tk.nextToken());

			for (int i = 0; i < y; i++) {
				arr[i]=br.readLine().toCharArray();	
			}
			int answer = 0;

			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (arr[i][j] == 'L') {
						answer=Math.max(answer, bfs(i, j));
					}
				}
			}
			System.out.println(answer);

	}

}
