package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_2644 {
	static int num;
	static int a, b, n;
	static ArrayList<Integer>[] arr;
	static int answer = 101;
	static boolean[] check;

	public static void dfs(int j, int ans) {
		check[j]=true;
		if (answer >= ans) {
			if (j == b) {
				answer = ans;
			} else {
				for (int k : arr[j]) {
					if(!check[k]) {
						dfs(k,ans+1);
					}
				}
			}
		}
		check[j]=false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(tk.nextToken());
		b = Integer.parseInt(tk.nextToken());
		n = Integer.parseInt(br.readLine());
		check=new boolean[num+1];
		arr=new ArrayList[num+1];
		for(int i=0;i<=num;i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		dfs(a,0);
		if (answer == 101) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}
