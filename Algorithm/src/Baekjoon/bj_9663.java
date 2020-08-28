package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_9663 {

	static int[] chess_column;
	static int n, answer = 0;

	//queen이 갈 수 있는 자리를 검사한다.
	public static void checkQueen(int row) {
		if (row == n + 1) {
			answer++;
		} else {
			for (int i = 1; i <= n; i++) {
				if (row == 1) {
					chess_column[1] = i;
					checkQueen(row + 1);
				} else {
					boolean check=true;
					for (int j = 1; j < row; j++) {
						//두 조건 중 하나라도 어긋나면 (가로, 대각선) 그 자리에 둘 수 없다.
						if (chess_column[j] == i || Math.abs(i - chess_column[j]) == row - j) {
							check=false;
							break;
						}
					}
					if(check){
						chess_column[row] = i;
						checkQueen(row + 1);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		chess_column = new int[n + 1];
		checkQueen(1);

		System.out.println(answer);
	}

}
