package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1759 {

	static int L;
	static int C;
	static char[] words;

	public static void findpass(int index, int depth, String password, int consonant, int vowel) {
		if (depth == L) {
			if (vowel > 0 && consonant > 1) {
				System.out.println(password);
			}
		} else {
			int len = C - (L - depth);
			for (int i = index; i <= len; i++) {
				if (words[i] == 'a' || words[i] == 'e' || words[i] == 'i' || words[i] == 'o' || words[i] == 'u') {
					findpass(i + 1, depth + 1, password + words[i], consonant, vowel + 1);
				} else {
					findpass(i + 1, depth + 1, password + words[i], consonant + 1, vowel);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());

		words = new char[C];

		tk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			words[i] = tk.nextToken().charAt(0);
		}

		Arrays.sort(words);

		findpass(0, 0, "", 0, 0);
	}

}
