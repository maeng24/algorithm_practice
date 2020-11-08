package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class expression implements Comparable<expression> {
	private int index;
	private int number;

	public expression(int index, int number) {
		super();
		this.index = index;
		this.number = number;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int compareTo(expression o) {
		// TODO Auto-generated method stub
		return o.getIndex() - this.index;
	}

}

public class bj_17124 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		PriorityQueue<expression> expressions = new PriorityQueue<>();

		int len = exp.length();

		for (int i = 0; i < len; i++) {

			int index = 0;
			String number = "";

			if (exp.charAt(i) == '+') {//양수일 경우
				i++;
				while (i < len && exp.charAt(i) != '+' && exp.charAt(i) != '-') {
					if (exp.charAt(i) != 'x') {
						number += exp.substring(i, i + 1);
					} else {
						index++;
					}
					i++;
				}
				i--;
				int n = 1;
				index++;
				if (number != "") {
					n = Integer.parseInt(number);
					n /= index;
				}
				if (n != 0) {
					expressions.add(new expression(index, n));
				}
			} else if (exp.charAt(i) == '-') {// 음수일 경우
				i++;
				while (i < len && exp.charAt(i) != '+' && exp.charAt(i) != '-') {//다음식을 만나면 세는 것을 그만 둔다.
					if (exp.charAt(i) != 'x') {//상수
						number += exp.substring(i, i + 1);
					} else {//지수
						index++;
					}
					i++;
				}
				i--;
				int n = -1;
				index++;
				if (number != "") {
					n = -Integer.parseInt(number);
					n /= index;
				}
				if (n != 0) {//상수가 0이 아닐경우
					expressions.add(new expression(index, n));
				}
			} else {// 첫번째 숫자가 양수일 때
				while (i < len && exp.charAt(i) != '+' && exp.charAt(i) != '-') {
					if (exp.charAt(i) != 'x') {
						number += exp.substring(i, i + 1);
					} else {
						index++;
					}
					i++;
				}
				i--;
				int n = 1;
				index++;
				if (number != "") {
					n = Integer.parseInt(number);
					n /= index;
				}
				if (n != 0) {
					expressions.add(new expression(index, n));
				}
			}
		}

		if (expressions.isEmpty()) {// 식이 없을 경우
			System.out.println("W");
		} else {//식이 있을 경우
			int ind = expressions.peek().getIndex();
			int num = expressions.poll().getNumber();

			if (num == 1) {//첫번째 식은 +가 들어가지 않는다.

			} else if (num == -1) {
				System.out.print("-");
			} else {
				System.out.print(num);
			}
			for (int i = 0; i < ind; i++) {
				System.out.print("x");
			}

			while (!expressions.isEmpty()) {
				ind = expressions.peek().getIndex();
				num = expressions.poll().getNumber();

				if (num > 1) {
					System.out.print("+" + num);
				} else if (num == 1) {
					System.out.print("+");
				} else if (num == -1) {
					System.out.print("-");
				} else {
					System.out.print(num);
				}
				for (int i = 0; i < ind; i++) {
					System.out.print("x");
				}
			}
			System.out.print("+W");
		}
	}

}
