package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int answer=0;
		int[] numbers=new int[10];
		String roomnum=br.readLine();
		int roomnumber=Integer.parseInt(roomnum);
		
		if(roomnumber==0){
			numbers[0]=roomnum.length();
		}
		
		while(roomnumber>0){
			numbers[roomnumber%10]++;
			roomnumber/=10;
		}
		
		numbers[6]=(int) Math.ceil((numbers[6]+numbers[9])/2.0);
		
		for(int i=0;i<9;i++){
			answer=Math.max(answer, numbers[i]);
		}

		System.out.println(answer);
	}

}
