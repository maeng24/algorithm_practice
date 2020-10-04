package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2458 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		boolean[][] lencomp=new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++){
			tk = new StringTokenizer(br.readLine(), " ");
			lencomp[Integer.parseInt(tk.nextToken())][Integer.parseInt(tk.nextToken())]=true;
		}
		
		//플로이드 와샬로 키를 비교할 수 있는 지 구한다.
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				for(int k=1;k<=N;k++){
					if(i==j){
                        break;
                    }
					if(lencomp[i][k]&&lencomp[k][j]){
						lencomp[i][j]=true;
					}
                    if(lencomp[N-i+1][k]&&lencomp[k][N-j+1]){
						lencomp[N-i+1][N-j+1]=true;
					}
				}
			}
		}
		
		int answer=0;
		for(int i=1;i<=N;i++){
			int count=0;
			for(int j=1;j<=N;j++){
				if(lencomp[i][j]||lencomp[j][i]){
					count++;
				}
			}
			if(count==N-1){
				answer++;
			}
		}
		System.out.println(answer);
	}

}
