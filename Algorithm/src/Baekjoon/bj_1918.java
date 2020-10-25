package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String exp = br.readLine();
		int len = exp.length();
		Stack<Character> operations = new Stack<>();

		// 수식 바꾸기
		String answer = "";
		for (int i = 0; i < len; i++) {
			char c = exp.charAt(i);
			switch (c) {
			case '(':
				operations.add(c);
				break;
			case ')':
				while (!operations.isEmpty()) {
					char op = operations.pop();
					if (op == '(') {
						break;
					}
					answer += op;
				}
				break;
			case '+':
			case '-':
				while (!operations.isEmpty()) {
					char op = operations.pop();
					if (op == '(') {
						operations.add(op);
						break;
					}
					answer += op;
				}
				operations.add(c);
				break;
			case '*':
			case '/':
				while (!operations.isEmpty()) {
					char op = operations.pop();
					if (op == '('||!(op=='*'||op=='/')) {
						operations.add(op);
						break;
					}
					answer += op;
				}
				operations.add(c);
				break;

			default:
				answer += c;
			}
		}
		// 남은 표기식을 뒤에 붙인다.
		while (!operations.isEmpty()) {
			answer += operations.pop();
			
		}
		System.out.println(answer);
	}

}
