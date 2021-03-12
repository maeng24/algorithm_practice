package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1654 {
	static int[] lines;
	static int K,N;
	static long maxlen=0;
	
	public static void binarySearch(long start, long end) {
		long mid = (start + end) / 2;

		long linelen = 0;

		for (int i = 0; i < K; i++) {
			linelen += lines[i] / mid;
		}

		if (start <= end) {
			if (linelen < N) { 
				binarySearch(start, mid - 1);
			} else { 
				maxlen=Math.max(mid, maxlen);
				binarySearch(mid + 1, end);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(tk.nextToken());
		N = Integer.parseInt(tk.nextToken());
		
		lines = new int[K];
		for (int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(lines);

		binarySearch(1, lines[K-1]);

		System.out.println(maxlen);
	}

}
