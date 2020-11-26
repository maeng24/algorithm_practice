package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1065{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num = Integer.parseInt(str);
		int answer=0;
		if (num >= 100) {
			if (num == 1000) {
				for (int i = 100; i < 1000; i++) {
					int num1=i/100;
					int num2=(i%100)/10;
					int num3=i%10;
					if(num1-num2==num2-num3) {
						answer++;
					}
				}
			} else {
				for(int i=100;i<=num;i++) {
					int num1=i/100;
					int num2=(i%100)/10;
					int num3=i%10;
					if(num1-num2==num2-num3) {
						answer++;
					}
				}

			}
		}
		if (num >= 10){
			if (num >= 100) {
				answer+=90;
			} else {
				answer+=num-9;
			}

		}
		if (num >= 10) {
			answer+=9;
		} else {
			answer+=num;
		}
		System.out.println(answer);
	}
}
