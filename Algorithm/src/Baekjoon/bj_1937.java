package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1937 {
	public static int[][] forest;
	public static int[][] visit;
	public static int[] movex = { 1, 0, -1, 0 };
	public static int[] movey = { 0, 1, 0, -1 };
	public static int num;

	//dfs+dp
	public static int checkbamboo(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int nextx = x + movex[i];
			int nexty = y + movey[i];
			if (nextx >= 0 && nextx < num && nexty >= 0 && nexty < num && forest[nexty][nextx] > forest[y][x]) {
				if (visit[nexty][nextx] == -1) {
					visit[y][x] = Math.max(visit[y][x], checkbamboo(nexty, nextx));
				}else{//이미 답이 구해진 칸은 있는 답을 사용한다.
					visit[y][x]= Math.max(visit[y][x], visit[nexty][nextx]+1);
				}
			}
		}
		if (visit[y][x] == -1) {//이동 불가일 경우 자기 자신만 저장
			visit[y][x] = 1;
		}
		return visit[y][x]+1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());

		forest = new int[num][num];
		visit = new int[num][num];

		for (int i = 0; i < num; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < num; j++) {
				visit[i][j] = -1;
				forest[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		for(int i=0;i<num;i++){
			for(int j=0;j<num;j++){
				if(visit[i][j]==-1){
					checkbamboo(i,j);
				}
			}
		}
		
		int answer=0;
		for(int i=0;i<num;i++){
			for(int j=0;j<num;j++){
				answer=Math.max(answer, visit[i][j]);
			}
		}
		System.out.println(answer);
	}

}
