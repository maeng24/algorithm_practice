package Leetcode;

import java.io.IOException;

public class LongestSubstringWithoutRepeatingCharacters {
	
	
	public static int lengthOfLongestSubstring(String s) {
		
		int startidx=0,endidx=0;
		int answer=1;
		int slen=s.length();
		boolean[] alphabet=new boolean[27];
		char c=' ';
		
		for(int i=0;i<slen;i++){
			c=(char) (s.charAt(i)-97);
			System.out.println(i+":"+s.charAt(i)+" : "+answer+" / "+alphabet[c]);
			if(!alphabet[c]){
				alphabet[c]=true;
				endidx++;
				answer=Math.max(endidx-startidx, answer);
				
			}else{
				while(alphabet[c]){
					alphabet[s.charAt(startidx++)-97]=false;
				}
				System.out.println(startidx);
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
