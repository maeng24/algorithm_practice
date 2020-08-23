package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1987 {

	static char[][] board;
	static int C;
	static int R;
	static int[] xmove = { 1, 0, -1, 0 };
	static int[] ymove = { 0, 1, 0, -1, };
	static boolean[] alphabet;
	static int answer=0;
	
	//깊이 우선 탐색으로 보드 검사
	public static void boardmove(int x, int y,int depth){
		alphabet[board[y][x]-65]=true;
		for(int i=0;i<4;i++){
			int nexty=y+ymove[i];
			int nextx=x+xmove[i];
			if(nextx>=0&&nextx<C&&nexty>=0&&nexty<R){
				if(alphabet[board[nexty][nextx]-65]==false){
					boardmove(nextx,nexty,depth+1);
				}
			}
		}
		answer=Math.max(answer, depth);
		alphabet[board[y][x]-65]=false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());

		alphabet = new boolean[27];
		board = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str=br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		boardmove(0,0,1);
		System.out.println(answer);
	}
}
