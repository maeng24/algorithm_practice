package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2166 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		double[][] pos = new double[num][2];

		for (int i = 0; i < num; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			pos[i][0]=Integer.parseInt(tk.nextToken());
			pos[i][1]=Integer.parseInt(tk.nextToken());
		}
		
		//신발끈 정리를 이용해서 넓이를 구한다.
		double answer=0;
		for(int i=0;i<num-1;i++){
			answer+=pos[i][0]*pos[i+1][1];
			answer-=pos[i][1]*pos[i+1][0];
		}
		answer+=pos[num-1][0]*pos[0][1];
		answer-=pos[num-1][1]*pos[0][0];
		answer=Math.abs(answer)/2;
		//소수점 둘째자리에서 반올림
		System.out.printf("%.1f", answer);
	}
}
