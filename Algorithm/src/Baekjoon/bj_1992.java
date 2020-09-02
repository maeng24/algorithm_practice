package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1992 {

	static int len;
	static int[][] image;
	static String result="";

	// 분할 정복법으로 쿼드 트리 알고리즘 만들기
	public static void quadTree(int x, int y, int length) {
		int count=0;
		for (int i = y; i < y + length; i++) {
			for (int j = x; j < x + length; j++) {
				if (image[i][j] == 0) {
					count++;
				} 
			}
		}

		if (count == length * length) {
			result += "0";
		} else if (count == 0) {
			result += "1";
		} else {
			result += "(";
			quadTree(x, y, length / 2);
			quadTree(x + length / 2, y, length / 2);
			quadTree(x, y + length / 2, length / 2);
			quadTree(x + length / 2, y + length / 2, length / 2);
			result += ")";
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());

		image = new int[len][len];

		for (int i = 0; i < len; i++) {
			String str = br.readLine();
			for (int j = 0; j < len; j++) {
				image[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}
		
		quadTree(0, 0, len);
		
		System.out.println(result);
	}

}
