package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9465 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			int length = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][length];
			int[][] point = new int[2][length];

			// 점수 받아 배열 채우기
			for (int j = 0; j < 2; j++) {
				StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < length; k++) {
					sticker[j][k] = Integer.parseInt(tk.nextToken());
				}
			}

			// dp로 점수 계산하기
			// 초기값
			point[0][0] = sticker[0][0];
			point[1][0] = sticker[1][0];
			point[0][1] = sticker[1][0]+sticker[0][1];
			point[1][1] = sticker[0][0]+sticker[1][1];
			
			// 전부 계산
			for(int j=2;j<length;j++){
				point[0][j]=Math.max(point[1][j-2],Math.max(point[0][j-2], point[1][j-1]))+sticker[0][j];
				point[1][j]=Math.max(point[0][j-2],Math.max(point[1][j-2], point[0][j-1]))+sticker[1][j];
			}
			
			if(point[0][length-1]>point[1][length-1]){
				System.out.println(point[0][length-1]);
			}else{
				System.out.println(point[1][length-1]);
			}
		}
	}
}
