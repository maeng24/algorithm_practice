package Baekjoon;

import java.util.Scanner;

public class bj_2960 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] numbers = new boolean[N + 1];
		int minnum = 2;
		int answer = 0;

		while (K > 0) {
			for (int i = 1; i*minnum <= N; i++) {
				if (!numbers[i * minnum]) {
					numbers[i * minnum] = true;
					K--;
					if (K == 0) {
						answer = i * minnum;
						break;
					}
				}
			}
			while(numbers[minnum]&&minnum<=N){
				minnum++;
			}
			
		}
		System.out.println(answer);
	}

}
