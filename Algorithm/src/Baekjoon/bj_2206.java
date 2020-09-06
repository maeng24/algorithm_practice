package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2206 {
	static int answer = 1000001;
	static int[] mov_x = { 1, 0, -1, 0 };
	static int[] mov_y = { 0, 1, 0, -1 };

	//현재 위치에 대한 정보
	public static class Point {
		int x;
		int y;
		boolean breakwall;
		int dis;

		public Point(int x, int y, boolean breakwall, int dis) {
			this.x = x;
			this.y = y;
			this.breakwall = breakwall;
			this.dis = dis;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int y = Integer.parseInt(tk.nextToken());
		int x = Integer.parseInt(tk.nextToken());

		int[][] arr = new int[y][x];
		boolean[][][] check = new boolean[2][y][x];
		check[0][0][0] = true;
		check[1][0][0] = true;
		
		for (int i = 0; i < y; i++) {
			String str = br.readLine();
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(0, 0, false, 1));
		
		while (!queue.isEmpty()) {
			int xx = queue.peek().x;
			int yy = queue.peek().y;
			int dis = queue.peek().dis;
			boolean breakwall = queue.poll().breakwall;
		
			if (xx == arr[0].length - 1 && yy == arr.length - 1) {
				answer=Math.min(answer, dis);
			} else {
				for (int i = 0; i < 4; i++) {
					int next_x =xx+ mov_x[i];
					int next_y =yy+ mov_y[i];
					if (next_x >= 0 && next_x < arr[0].length && next_y >= 0 && next_y < arr.length) {
						if (arr[next_y][next_x] == 0) {
							if(breakwall==true&&check[1][next_y][next_x]==false){
								queue.add(new Point(next_x, next_y, breakwall, dis + 1));
								check[1][next_y][next_x]=true;
							}else if(breakwall==false&&check[0][next_y][next_x]==false){
								queue.add(new Point(next_x, next_y, breakwall, dis + 1));
								check[0][next_y][next_x]=true;
							}
						} else if (arr[next_y][next_x] == 1 && breakwall == false) {
							queue.add(new Point(next_x, next_y, true, dis + 1));
							check[1][next_y][next_x]=true;
						}
					}
				}
			}
		}

		if (answer == 1000001) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

}
