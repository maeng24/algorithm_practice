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
			String[] numbers=new String[n];
			int minlen=10;
			for(int j=0;j<n;j++){
				numbers[j]=br.readLine();
				minlen=Math.min(numbers[j].length(), minlen);
				Arrays.sort(numbers);
			}
			
			HashMap<String, Integer> makelist=new HashMap<>();
			for(int j=0;j<n;j++){
				String str=numbers[j].substring(0,minlen);
				if(makelist.containsKey(str)){
					success=false;
					break;
				}else{
					makelist.get(str);
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
