package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2352 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		int[] dest = new int[num + 1];
		int[] answer = new int[num + 1];
		int ans=0;
		
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= num; i++) {
			dest[i] = Integer.parseInt(tk.nextToken());
		}

		for (int i = 1; i <= num; i++) {
			if (dest[i] == 0) {
				continue;
			}
			answer[i] = 1;
			for (int j = 1; j < i; j++) {
				
				if (dest[j] < dest[i]) {
					answer[i] = Math.max(answer[j] + 1, answer[i]);
				}
			}
			ans=Math.max(answer[i],ans);
		}
		System.out.println(ans);
	}

}
