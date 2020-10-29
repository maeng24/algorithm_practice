package Baekjoon;

import java.util.Scanner;

public class bj_1074 {

	public static int N, r, c, answer;
	static int[] xmov = { 0, 1, 0, 1 };
	static int[] ymov = { 0, 0, 1, 1 };

	public static void searchpos(int depth, int x, int y) {
		// 끝까지 들어왔을 때
		if (depth ==0) {
			boolean end=false;
			//System.out.println(x+" "+y+" "); // 마지막으로 들어온 좌표
			for (int i = y; i < y + 2; i++) {
				for (int j = x; j < x + 2; j++) {
					if (i == r && j == c) {
						end=true;
						break;
					}
					answer++;
				}
				if(end){
					break;
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int startx = (int) (x + xmov[i] * Math.pow(2, depth - 1));
				int starty = (int) (y + ymov[i] * Math.pow(2, depth - 1));
				int endx = (int) (startx + Math.pow(2, depth - 1));
				int endy = (int) (starty + Math.pow(2, depth - 1));

				// 사각형 범위 안에 있으면 재귀, 없으면 갯수 증가
				if (startx <= c && starty <= r && endx > c && endy > r) {
					searchpos(depth - 1, startx, starty);
					break;
				} else {
					answer += Math.pow((startx - endx), 2);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 2 5 6
		// 3 4 7 8
		// 9 10 13 14
		// 11 12 15 16
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		answer = 0;

		searchpos(N, 0, 0);
		System.out.println(answer );
	}

}
