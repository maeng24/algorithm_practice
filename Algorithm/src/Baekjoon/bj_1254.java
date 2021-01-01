package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1254 {
	static String str;

	//팰린드롬이 맞는지 검사
	public static boolean checkpalindrom(String s) {
		int len = s.length() - 1;
		int end = len / 2;
		for (int i = 0; i <= end; i++) {
			if (s.charAt(i) != s.charAt(len - i)) {// 대칭되지 않으면 팰린드롬수가 아니다
				return false;
			}
		}
		return true;
	}

	public static int makepalindrom() {
		int len=str.length();
		for (int i = 0; i < len; i++) {
			if (checkpalindrom(str.substring(i))) {//팰린드롬이 맞다면 대칭되지 않은 부분만 추가해서 리턴
				return len + i;
			}
		}
		return len * 2 - 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();

		System.out.println(makepalindrom());
	}

}
