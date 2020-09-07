package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1920 {

	static int[] numbers;

	// ��͸� �̿��� ���� ������
	public static void checkNumbers(int number, int right, int left) {
		int mid = (right + left) / 2;
		if (numbers[mid] == number) {
			System.out.println(1);
		} else if (left == mid) {
			if (numbers[mid + 1] == number) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		} else if (numbers[mid] < number) {
			checkNumbers(number, right, mid);
		} else if (numbers[mid] > number) {
			checkNumbers(number, mid, left);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(tk.nextToken());
		}

		// ����
		Arrays.sort(numbers);

		int M = Integer.parseInt(br.readLine());
		tk = new StringTokenizer(br.readLine(), " ");

		// M�� ���� �ԷµǴ� ���ڰ� �迭�� �ִ��� Ȯ���Ѵ�.
		for (int i = 0; i < M; i++) {
			checkNumbers(Integer.parseInt(tk.nextToken()), N - 1, 0);
		}

	}

}
