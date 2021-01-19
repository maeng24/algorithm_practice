package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(tk.nextToken());
		int k=Integer.parseInt(tk.nextToken());
		
	    int[] weight=new int[n+1];
		int[] value=new int[n+1];
		int[][] arr=new int[n + 1][k + 1];
		
	    for (int i = 1; i <= n; i++) {
	    	tk=new StringTokenizer(br.readLine()," ");
			weight[i]=Integer.parseInt(tk.nextToken());
			value[i]=Integer.parseInt(tk.nextToken());
		}
	    
	    //냅색 알고리즘
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (weight[i] <= j) {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i-1][j-weight[i]]+value[i]);
				}
				else {
					arr[i][j] = arr[i - 1][j];
				}
			}
		}
		System.out.println(arr[n][k]);

	}

}
