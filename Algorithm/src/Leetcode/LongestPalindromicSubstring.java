package Leetcode;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {

		char[] strs = s.toCharArray();
		int strs_len = strs.length;
		boolean[][] palindrom = new boolean[strs_len][strs_len];

		String answer = "";
		int maxlen = -1;
		//dp를 사용해서 팰린드롬을 확인한다.
		for (int i = 0; i < strs_len; i++) {
			for (int j = i; j >=0 ; j--) {
				//대칭으로 같거나, 앞뒤가 같을 때 혹은 한글자일 때
				if ((strs[i] == strs[j]) && (i - j <= 2 || palindrom[i - 1][j + 1])) {
					palindrom[i][j] = true;
					if (maxlen < i - j) {//가장 긴 부분일 때 답 교체
						maxlen = i - j;
						answer = s.substring(j, i + 1);
					}
				}
			}
		}
	
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
