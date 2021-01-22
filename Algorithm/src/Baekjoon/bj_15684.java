package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_15684 {

	static int N, H, E;
	static int[][] ladder;
	static int answer=5;
	public static void dfs(int y, int x, int depth){
		if(checkladder()){
			answer=Math.min(answer,depth);
		}else if(depth>3){
		}else{
			
			for(int i=0;i<H;i++){
				for(int j=0;j<N;j++){
					if(i==0&&j==0){
						i=y;
						j=x;
					}
					if(ladder[i][j]==0&&ladder[i][j+1]==0){
						ladder[i][j]=1;
						ladder[i][j+1]=-1;
						dfs(i,j,depth+1);
						ladder[i][j]=0;
						ladder[i][j+1]=0;
					}
				}
			}
			
		}
	}
	
	public static boolean checkladder(){
		for(int i=0;i<N;i++){
			int index=i;
			for(int j=0;j<H;j++){
				if(ladder[j][index]==1){
					index++;
				}else if(ladder[j][index]==-1){
					index--;
				}
			}if(index!=i){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		H = Integer.parseInt(tk.nextToken());

		ladder = new int[H][N];
		int a = 0, b = 0;
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(tk.nextToken()) - 1;
			b = Integer.parseInt(tk.nextToken()) - 1;
			ladder[a][b] = 1;
			ladder[a][b + 1] = -1;
		}
		
		E=N-1;
		dfs(0,0,0);
		if(answer==5){
			System.out.println(-1);
		}else{
			System.out.println(answer);
		}
	}

}
