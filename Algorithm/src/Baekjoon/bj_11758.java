package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		int P1x=Integer.parseInt(tk.nextToken());
		int P1y=Integer.parseInt(tk.nextToken());
		
		tk=new StringTokenizer(br.readLine()," ");
		int P2x=Integer.parseInt(tk.nextToken());
		int P2y=Integer.parseInt(tk.nextToken());
		
		tk=new StringTokenizer(br.readLine()," ");
		int P3x=Integer.parseInt(tk.nextToken());
		int P3y=Integer.parseInt(tk.nextToken());
		
		int answer;
		
		//CCW
		int ccw=P1x*P2y+P2x*P3y+P3x*P1y;
		ccw-=(P1y*P2x+P2y*P3x+P3y*P1x);

		if(ccw>0){
			answer=1;
		}else if(ccw==0){
			answer=0;
		}else{
			answer=-1;
		}
		
		System.out.println(answer);
	}

}
