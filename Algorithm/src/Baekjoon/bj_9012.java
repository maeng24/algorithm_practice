package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		char[] VPS=null;
		Stack<Character> stack=new Stack<>();
		boolean flag=false;
		
		for(int i=0;i<num;i++){
			stack.clear();
			VPS=br.readLine().toCharArray();
			int len=VPS.length;
			flag=false;
			
			//괄호 검사
			for(int j=0;j<len;j++){
				if(VPS[j]=='('){//시작하는 괄호는 스택에 넣는다.
					stack.push(VPS[j]);
				}else{
					if(stack.isEmpty()){//짝이 맞지 않으면 실패
						flag=true;
						break;
					}else{//짝이 맞으면 괄호를 스택에서 빼고 계속한다.
						stack.pop();
					}
				}
			}
			
			if(stack.isEmpty()&&!flag){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		
	}

}
