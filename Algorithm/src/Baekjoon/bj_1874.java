package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class bj_1874 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 1, cnt = 0;
		int num = sc.nextInt();
		
		ArrayList<Character> answer=new ArrayList<>();
		Stack<Integer> numbers = new Stack<>();
		
		//첫번째 숫자 넣고 시작
		numbers.add(n++);
		answer.add('+');
		
		//스택 수열 구하기
		for (int i = 0; i < num; i++) {
			//입력 받은 수가 팝되어야 한다.
			int nowpop = sc.nextInt();
			
			//팝되어야 하는 숫자보다 작으면 계속 넣는다.
			while (numbers.isEmpty() ||numbers.peek() < nowpop) {
				if (n > num) {
					break;
				}
				numbers.add(n++);
				answer.add('+');
			}
			
			//팝되어야 하는 숫자와 같으면 팝!
			if(!numbers.isEmpty() && numbers.peek() == nowpop) {
				numbers.pop();
				answer.add('-');
				cnt++;
			}
		}

		int len=answer.size();
		if (cnt == num) {
			for (int i = 0; i < len; i++) {
				System.out.println(answer.get(i));
			}
		} else {
			System.out.println("NO");
		}
	}

}
