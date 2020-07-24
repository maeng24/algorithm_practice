package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1076 {

	public static void main(String[] args) throws IOException {
		String[][] elec={
				{"black","0"},{"brown","1"},{"red","2"},
				{"orange","3"},{"yellow","4"},{"green","5"},
				{"blue","6"},{"violet","7"},{"grey","8"},{"white","9"}
				};

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String resistance="";
		long value=0;
		
		for(int i=0;i<2;i++){
			String resis=br.readLine();
			for(int j=0;j<10;j++){
				if(elec[j][0].equals(resis)){
					resistance+=elec[j][1];
					break;
				}
			}
		}
		
		String resis=br.readLine();
		value=Integer.parseInt(resistance);

		//0ÀÌ ¾Æ´Ò ¶§
		for(int j=1;j<10;j++){
			if(elec[j][0].equals(resis)){
				int num=Integer.parseInt(elec[j][1]);
				while(num-->0){
					value*=10;
				}
				break;
			}
		}
		
		System.out.println(value);
	}

}
