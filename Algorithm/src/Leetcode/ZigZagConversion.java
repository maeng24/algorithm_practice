package Leetcode;

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		int len = s.length();
		String answer = "";
		int end = 0;
		if (numRows == 1 || len == 1) {
			return s;
		} else {
			// nR-1가로만큼 nR*2-2단어가 들어간다.
			int plusidx = numRows - 1;
			int plusidx2x = plusidx * 2;
			int nextwrd = 0;
			for (int i = 0; i < numRows; i++) {
				for (int j = i; j < len; j += plusidx2x) {
					answer += s.substring(j, j + 1);
					nextwrd = j + plusidx2x - (i * 2);
					if (i != 0 && i != plusidx && nextwrd < len) {
						answer += s.substring(nextwrd, nextwrd + 1);
					}
				} // 1 5 7 2 4 8 nR 4 pidx 3 pdex2 6
			}

		}
		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
