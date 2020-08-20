package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2167 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		int y = Integer.parseInt(tk.nextToken());
		int x = Integer.parseInt(tk.nextToken());
		
		int[][] arr=new int[y+1][x+1];
		
		//입력받으며 미리 DP를 진행한다
		for(int i=1;i<=y;i++){
			tk = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<=x;j++){
				arr[i][j]=Integer.parseInt(tk.nextToken());
				arr[i][j]=arr[i][j]+arr[i][j-1];
			}
		}

		int num = Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++){
			tk = new StringTokenizer(br.readLine(), " ");
			int starty=Integer.parseInt(tk.nextToken());
			int startx=Integer.parseInt(tk.nextToken());
			int endy=Integer.parseInt(tk.nextToken());
			int endx=Integer.parseInt(tk.nextToken());

			//입력 받은 수 이전의 합을 빼줌
			int sum=0;
			for(int j=starty;j<=endy;j++){
				sum+=arr[j][endx]-arr[j][startx-1];
			}
			System.out.println(sum);
		}
	}
}
