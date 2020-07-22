package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2468 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int[][] district_h=new int[n][n];
		int min_h=101;
		int max_h=-1;
		
		for(int i=0;i<n;i++){
			StringTokenizer tk=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++){
				district_h[i][j]=Integer.parseInt(tk.nextToken());
				if(district_h[i][j]<min_h){
					min_h=district_h[i][j];
				}else if(district_h[i][j]>max_h){
					max_h=district_h[i][j];
				}
			}
		}
		
		int[] x_pos={0,1,0,-1};
		int[] y_pos={1,0,-1,0};
		int answer=1;
		
		//최소 높이부터 최대높이 직전까지만 검사
		for(int i=min_h;i<max_h;i++){
			
			int num=0;
			Queue<int[]> point=new LinkedList<int[]>();
			boolean[][] check=new boolean[n][n];
			
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					//bfs로 검사
					if(district_h[j][k]>i&&!check[j][k]){
						
						point.add(new int[]{j,k});
						check[j][k]=true;
						
						while(!point.isEmpty()){
							int x=point.peek()[1];
							int y=point.poll()[0];
							for(int t=0;t<4;t++){
								//새 좌표를 저장
								int nowy=y+y_pos[t];
								int nowx=x+x_pos[t];
								//좌표가 존재하는지, 안전지대인지, 이미 방문한 곳인지 검사
								if(nowy<n&&nowy>-1&&nowx<n&&nowx>-1&&district_h[nowy][nowx]>i&&!check[nowy][nowx]){
									check[nowy][nowx]=true;
									point.add(new int[]{nowy,nowx});
								}
							}
						}
						num++;
					}
				}
			}
			answer=Math.max(num, answer);
		}
		System.out.println(answer);
	}
}
