package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_11727 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int[] tiles=new int[num+2];
		
		tiles[0]=0;
		tiles[1]=1;
		tiles[2]=3;
		
		for(int i=3;i<=num;i++){
			tiles[i]=(tiles[i-2]*2+tiles[i-1])%10007;
		}
		
		System.out.println(tiles[num]);

	}

}
