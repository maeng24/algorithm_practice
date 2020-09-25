package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_10775 {

	static int[] gate;

	static int find(int x) {
		if (gate[x] == x){
			return x;
		}
		else{
			return gate[x] = find(gate[x]);
		}
	}

	static void union(int x, int y) {
		gate[find(x)] = find(y);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int answer = 0;

		// 게이트의 수 만큼 배열 선언
		gate = new int[G+1];
		
		for(int i=1;i<=G;i++){
			gate[i]=i;
		}

		// 들어올 수 있는 만큼 들여보낸다.
		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			g=find(g);
			
			if(g == 0){
                break;
			}
                
            union(g, g - 1);
            answer++;
		}

		System.out.println(answer);
	}

}
