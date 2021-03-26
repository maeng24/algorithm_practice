package Leetcode;

import java.io.IOException;

public class LongestSubstringWithoutRepeatingCharacters {
	
	
	public static int lengthOfLongestSubstring(String s) {
		
		int startidx=0,endidx=0;
		int answer=0;
		int slen=s.length();
		boolean[] alphabet=new boolean[128];
		char c=' ';
		
		//그리디.문자열의 길이만큼 확인하며 중복언어가 나오면 앞부분을 검사하며 뒤로밀고 , 아니면 최대 길이를 계산.
		for(int i=0;i<slen;i++){
			c=(char) (s.charAt(i)-97);
			if(!alphabet[c]){
				alphabet[c]=true;
				endidx++;
				answer=Math.max(endidx-startidx, answer);
				
			}else{
				while(alphabet[c]){
					alphabet[s.charAt(startidx++)]=false;
				}
				alphabet[c]=true;
				endidx++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(lengthOfLongestSubstring("abcabcaa"));
	}
	
}
