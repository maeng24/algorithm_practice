package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2178 {
	public static int[] xpos={0,1,0,-1};
	public static int[] ypos={1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(tk.nextToken());
		int M=Integer.parseInt(tk.nextToken());
		
		int[][] maze=new int[N][M];
		boolean[][] visit=new boolean[N][M];
		
		for(int i=0;i<N;i++){
			String str=br.readLine();
			for(int j=0;j<M;j++){
				maze[i][j]=Integer.parseInt(str.substring(j,j+1));
			}
		}
		
		Queue<int[]> findway=new LinkedList<>();
		findway.add(new int[]{0,0});
		int answer=1;
		boolean find=false;
		N--;
		M--;
		
		//bfs로 미로탐색
		while(!findway.isEmpty()){
			int len=findway.size();
			
			for(int i=0;i<len;i++){
				int[] arr=findway.poll();
				
				for(int j=0;j<4;j++){
					int nexty=arr[0]+ypos[j];
					int nextx=arr[1]+xpos[j];
					//도착지에 도달했다면 반복문을 빠져나간다.
					if(nexty==N&&nextx==M){
						find=true;
						break;
					}else if(nexty>=0&&nexty<=N&&nextx>=0&&nextx<=M&&
							!visit[nexty][nextx]&&maze[nexty][nextx]!=0){//다음칸 이동
						visit[nexty][nextx]=true;
						findway.add(new int[]{nexty,nextx});
					}
				}
			}
			answer++;
			if(find){
				break;
			}
		}
		System.out.println(answer);
	}
}
