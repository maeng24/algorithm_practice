package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1747 {

	//팰린드롬 수 확인
	public static boolean checkpal(String number) {

		StringBuffer stringBuffer = new StringBuffer(number);
		String reverse = stringBuffer.reverse().toString();

		if (reverse.equals(number)) {
			return true;
		} else {
			return false;
		}
	}

	//소수 확인
	public static boolean checkprime(int number) {

		int num = (int) Math.sqrt(number);

		for (int i = 2; i <= num; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String number = br.readLine();
		//1은 소수가 아님
		if (number.equals("1")) {
			System.out.println(2);
		} else {

			while (true) {
				int num = Integer.parseInt(number);
				if (checkpal(number) && checkprime(num)) {
					break;
				}

				number = Integer.toString(num + 1);

			}
			System.out.println(number);
		}
	}

}
