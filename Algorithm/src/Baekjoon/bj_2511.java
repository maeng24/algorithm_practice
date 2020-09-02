package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2511 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] Acards = new int[10];
		int[] Bcards = new int[10];
		int Apoint = 0;
		int Bpoint = 0;
		int lastwin = 0;// ÃÊ±â °ª 0, A½Â¸® 1, B½Â¸® 2

		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 10; i++) {
			Acards[i] = Integer.parseInt(tk.nextToken());
		}

		tk = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 10; i++) {
			Bcards[i] = Integer.parseInt(tk.nextToken());
		}

		// ½ÂÁ¡ ±¸ÇÏ±â
		for (int i = 0; i < 10; i++) {
			if (Acards[i] > Bcards[i]) {
				Apoint += 3;
				lastwin = 1;
			} else if (Acards[i] < Bcards[i]) {
				Bpoint += 3;
				lastwin = 2;
			} else {
				Apoint += 1;
				Bpoint += 1;
			}
		}
		
		System.out.println(Apoint+" "+Bpoint);

		if (Apoint > Bpoint) { // A½Â¸®
			System.out.println("A");
		} else if (Apoint < Bpoint) { // B½Â¸®
			System.out.println("B");
		} else { // ºñ±è
			if (lastwin == 1) { // A½Â¸®
				System.out.println("A");
			} else if (lastwin == 2) { // B½Â¸®
				System.out.println("B");
			} else { // ºñ±è
				System.out.println("D");
			}
		}
	}

}
