package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1926 {

	public static int[][] paper;
	public static boolean[][] visit;
	public static int n,m;
	public static int[] movex={1,0,-1,0};
	public static int[] movey={0,1,0,-1};
	
	public static int checkpic(int y, int x, int depth){
		visit[y][x]=true;
		
		for(int i=0;i<4;i++){
			int nextx=x+movex[i];
			int nexty=y+movey[i];
			if(nextx>=0&&nextx<m&&nexty>=0&&nexty<n&&paper[nexty][nextx]==1&&!visit[nexty][nextx]){
				depth=checkpic(nexty,nextx,depth+1);
			}
		}
		return depth;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		n=Integer.parseInt(tk.nextToken());
		m=Integer.parseInt(tk.nextToken());
		
		paper=new int[n][m];
		visit=new boolean[n][m];
		
		for(int i=0;i<n;i++){
			tk=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++){
				paper[i][j]=Integer.parseInt(tk.nextToken());
			}
		}
		
		int picnum=0;
		int answer=0;
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(!visit[i][j]&&paper[i][j]==1){
					answer=Math.max(answer, checkpic(i,j,1));
					picnum++;
				}
			}
		}
		
		System.out.println(picnum+"\n"+answer);
		
	}

}
