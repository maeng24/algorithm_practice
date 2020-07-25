package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_11726 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int width=Integer.parseInt(br.readLine());
		
		int[] tiles=new int[width+3];
		
		tiles[1]=1;
		tiles[2]=2;
		
		for(int i=3;i<width+1;i++){
			tiles[i]=(tiles[i-1]+tiles[i-2])%10007;
		}
		
		System.out.println(tiles[width]);
	}

}
