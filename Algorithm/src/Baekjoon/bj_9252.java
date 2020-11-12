package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_9252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		char[] ch1=br.readLine().toCharArray();
		char[] ch2=br.readLine().toCharArray();

		int ch1_len=ch1.length;
		int ch2_len=ch2.length;
		
		int[][] lcs=new int[ch1_len+1][ch2_len+1];
		
		//lcs 길이 구하기
		for(int i=0;i<ch1_len;i++){
			for(int j=0;j<ch2_len;j++){
				if(ch1[i]==ch2[j]){
					lcs[i+1][j+1]=lcs[i][j]+1;
				}else{
					lcs[i+1][j+1]=Math.max(lcs[i][j+1], lcs[i+1][j]);
				}
			}
		}
		
		//역추적으로 답을 구한다.
		int height=ch1_len;
		int width=ch2_len;
		Stack<Character> answer=new Stack<>();
		
		while(lcs[height][width]!=0){
			if(lcs[height][width]==lcs[height-1][width]){
				height--;
			}else if(lcs[height][width]==lcs[height][width-1]){
				width--;
			}else if(lcs[height][width]-1 ==lcs[height-1][width-1]){//같으면 넣고 대각선 위로 이동
				answer.push(ch1[height-1]);
				height--;
				width--;
			}
		}
		
		System.out.println(lcs[ch1_len][ch2_len]);
		StringBuilder sb=new StringBuilder();
		while(!answer.isEmpty()){
			sb.append(answer.pop());
		}
		System.out.println(sb);
	}

}
