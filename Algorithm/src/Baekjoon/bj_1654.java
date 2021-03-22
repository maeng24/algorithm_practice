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
	
	//이분탐색으로 선의 갯수 구하기
	public static void binarySearch(long start, long end) {
		long mid = (start + end) / 2;

		long linenum = 0;

		//필요한 갯수만큼 나오는지 확인하기 위해 정해진 갯수대로 전부 자른다.z
		for (int i = 0; i < K; i++) {
			linenum += lines[i] / mid;	
		}

		//갯수에 따라 이분탐색 진행
		if (start <= end) {
			if (linenum < N) { 
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
