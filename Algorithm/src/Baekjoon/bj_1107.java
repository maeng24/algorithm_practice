package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1107 {
	static boolean damagedbutton[] = new boolean[10];

	public static boolean check(int chanel) {

		if (chanel == 0) {
			if (damagedbutton[0] == true) {
				return false;
			}
			return true;
		}
		while (true) {
			if (damagedbutton[chanel % 10] == true) {
				return false;
			}
			if (chanel < 10) {
				return true;
			}
			chanel = chanel / 10;
		}
	}

	public static int button(int chanel) {
		int num = 0;
		while (true) {
			if (chanel + num == 100 || chanel - num == 100) {
				return num;
			}
			if (chanel - num >= 0 && check(chanel - num)) {
				if(Math.abs(chanel-100)<num + Integer.toString(chanel - num).length()){
					return Math.abs(chanel-100);
				}
				return num + Integer.toString(chanel - num).length();
			}
			if (check(chanel + num)) {
				if(Math.abs(chanel-100)<num + Integer.toString(chanel + num).length()){
					return Math.abs(chanel-100);
				}
				return num + Integer.toString(chanel + num).length();
			}
			
			
			num++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();

		int chanel = Integer.parseInt(num);

		int buttonnum = Integer.parseInt(br.readLine());
		if (buttonnum != 0) {
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < buttonnum; i++) {
				damagedbutton[Integer.parseInt(tk.nextToken())] = true;
			}
		}
		int answer = 0;
		if (chanel != 100) {
			answer = button(chanel);
		}
		System.out.println(answer);
	}
}

