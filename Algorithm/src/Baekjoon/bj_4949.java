package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_4949 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str=null;
		Stack<Character> stack=new Stack<>();
		boolean flag=false;
		
		while(true){
			str=br.readLine().toCharArray();
			int len=str.length;
			flag=false;
			stack.clear();
			
			//. 하나만 있으면 끝낸다.
			if(len==1&&str[0]=='.'){
				break;
			}

			//문자열 검사
			for(int i=0;i<len;i++){
				if(str[i]=='('){
					stack.push(str[i]);
				}else if(str[i]==')'){//소괄호의 짝이 맞을 경우 진행, 아닐 경우 탈출
					if(!stack.isEmpty()&&stack.peek()=='('){
						stack.pop();
					}else{
						flag=true;
						break;
					}
				}else if(str[i]=='['){
					stack.push(str[i]);
				}else if(str[i]==']'){//대괄호의 짝이 맞을 경우 진행, 아닐 경우 탈출
					if(!stack.isEmpty()&&stack.peek()=='['){
						stack.pop();
					}else{
						flag=true;
						break;
					}
				}
			}
			
			if(stack.isEmpty()&&!flag){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		
		}

	}

}
