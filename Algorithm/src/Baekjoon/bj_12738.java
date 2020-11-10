package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_12738 {

	static int result;
	static int[] answer;
	
	//이분탐색으로 자리 찾기
	public static void searchindex(int number) {
		int start = 0;
		int dest = result - 1;
		int mid = 0;
		while (start < dest) {
			mid = (start + dest) >> 1;
			if (answer[mid] < number) {
				start = mid + 1;
			} else {
				dest = mid;
			}
		}
		answer[dest] = number;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());

		int number = 0;
		answer = new int[len];

		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		result = 1;
		answer[0] = Integer.parseInt(tk.nextToken());

		for (int i = 1; i < len; i++) {
			number = Integer.parseInt(tk.nextToken());
			if (answer[result - 1] < number) {
				answer[result++] = number;
			} else {//다음 인덱스에 넣을 수 없다면 맞는 자리를 찾는다.
				searchindex(number);
			}
		}

		System.out.println(result);
	}
	
}
