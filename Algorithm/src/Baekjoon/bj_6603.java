package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_6603 {
	public static void dfs(int[] arr, int num, int numm,int t, int[] ans) {
		if (numm == 6) {
			System.out.println(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3] + " " + ans[4] + " " + ans[5]);
		} else {
			for (int i = t; i < num - (5 - numm); i++) {
				ans[numm] = arr[i];
				t++;
				dfs(arr, num, numm + 1,t, ans);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String tok= br.readLine();
			StringTokenizer st=new StringTokenizer(tok," ");
			int num=Integer.parseInt(st.nextToken());
			if (num == 0) {
				break;
			}
			int[] arr = new int[num];
			for (int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] ans = new int[num];

			dfs(arr, num, 0,0, ans);
			System.out.println();
		}

	}
}
