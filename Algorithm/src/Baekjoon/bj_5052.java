package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class bj_5052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
			boolean success=true;
			int n=Integer.parseInt(br.readLine());
			System.out.println(n);
			int[] numbers=new int[n];
			int minlen=10;
			for(int j=0;j<n;j++){
				String str=br.readLine();
				numbers[j]=Integer.parseInt(str);
				System.out.println(str.length()+" "+minlen);
				minlen=Math.min(str.length(), minlen);
			}
			Arrays.sort(numbers);
			
			HashMap<Integer, Integer> makelist=new HashMap<>();
			int divide=(int)Math.pow(10, minlen);
			System.out.println(divide);
			for(int j=0;j<n;j++){
				int number=numbers[j];
				while(number>divide){
					number/=10;
				}
				System.out.println(makelist.containsKey(number));
				if(makelist.containsKey(number)){
					success=false;
					break;
				}else{
					makelist.put(number,1);
				}
			}
			if(success){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}

	}

}
