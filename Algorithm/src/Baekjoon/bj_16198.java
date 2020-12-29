package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_16198 {

	static int n;
	static int[] energy;
	static boolean[] visit;
	static int answer=0;

	public static void maxenergy(int ans, int depth) {
		if (depth == 0) {
			answer=Math.max(ans, answer);
		} else {
			int prev = -1;//이전 인덱스를 저장하기 위함

			for (int i = 0; i < n; i++) {
				if (prev != -1 && !visit[i]) {
					for (int j = i + 1; j < n; j++) {//다음 인덱스를 확인
						if (!visit[j]) {
							visit[i] = true;
							maxenergy(ans+(energy[prev] * energy[j]), depth - 1);//재귀(dfs)
							visit[i]=false;
							prev=i;
							break;
						}
					}
				} else if (!visit[i]) {
					prev = i;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		energy = new int[n];
		visit = new boolean[n];

		StringTokenizer tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			energy[i] = Integer.parseInt(tk.nextToken());
		}

		maxenergy(0,n-2);//2개 이하로 남으면 연산 불가
		
		System.out.println(answer);
	}

}
