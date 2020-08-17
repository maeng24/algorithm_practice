package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1149 {

	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num= Integer.parseInt(br.readLine());
		arr=new int[num][3];
		for(int i=0;i<num;i++) {
			StringTokenizer tk=new StringTokenizer(br.readLine()," ");
			arr[i][0]=Integer.parseInt(tk.nextToken());
			arr[i][1]=Integer.parseInt(tk.nextToken());
			arr[i][2]=Integer.parseInt(tk.nextToken());
		}
		for(int i=1;i<num;i++) {
			arr[i][0]+=Math.min(arr[i-1][1], arr[i-1][2]);
			arr[i][1]+=Math.min(arr[i-1][0], arr[i-1][2]);
			arr[i][2]+=Math.min(arr[i-1][0], arr[i-1][1]);
		}
		int answer=Math.min(arr[num-1][0], arr[num-1][1]);
		System.out.println(Math.min(arr[num-1][2], answer));
	}
}
