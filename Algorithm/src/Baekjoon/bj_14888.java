package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14888 {
	static int[] numbers;
	static int[] math = new int[4];
	static int n, max = -1000000000, min = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		numbers = new int[n];

		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(tk.nextToken());
		}

		// 수식 저장
		tk = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 4; i++) {
			math[i] = Integer.parseInt(tk.nextToken());
		}
		
		makeformula(numbers[0],1);
		System.out.println(max+"\n"+min);
	}
	
	//dfs를 이용하여 모든 경우의 수를 검사한다. 브루트 포스
	public static void makeformula(int result, int depth) {
		if (depth == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
		} else {
			for (int i = 0; i < 4; i++) {
				if (math[i] != 0) {
					switch (i) {
					case 0:
						math[i]--;
						makeformula(result + numbers[depth], depth + 1);
						math[i]++;
						break;
					case 1:
						math[i]--;
						makeformula(result - numbers[depth], depth + 1);
						math[i]++;
						break;
					case 2:
						math[i]--;
						makeformula(result * numbers[depth], depth + 1);
						math[i]++;
						break;
					case 3:
						math[i]--;
						makeformula(result / numbers[depth], depth + 1);
						math[i]++;
						break;
					default:
						break;
					}
				}
			}
		}
	}
}
