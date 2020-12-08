package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2805 {

	static int N, M;
	static int[] trees;

	//이분탐색으로 잘라야 하는 위치 구하기
	public static long searchcut() {
		int start = 0;
		int end = trees[N - 1];
		int mid = 0;
		long answer = 0;

		while (start <= end) {
			long cuttree = 0;
			mid = (start + end) / 2;
			for (int i = 0; i < N; i++) {
				if (mid < trees[i]) { //자를 수 있는 나무는 자른 뒤의 길이를 합한다.
					cuttree += trees[i] - mid;
				}
			}

			if (cuttree >= M) {
				if (mid > answer) {
					answer = mid;
				}
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		trees = new int[N];

		tk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(tk.nextToken());
		}

		Arrays.sort(trees);
		System.out.println(searchcut());
	}

}
