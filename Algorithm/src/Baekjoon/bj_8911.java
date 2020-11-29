package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_8911 {

	static int[] movex={0,1,0,-1};
	static int[] movey={1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++){
			char[] move=br.readLine().toCharArray();
			int len=move.length;
			int direction=0; // 북0  동1  남2  서3 
			int xpos=0;
			int ypos=0;
			int maxx=0,minx=0,maxy=0,miny=0;
			
			for(int j=0;j<len;j++){
				switch (move[j]) {
				case 'F':
					xpos+=movex[direction];
					ypos+=movey[direction];
					break;
				case 'B':
					xpos-=movex[direction];
					ypos-=movey[direction];
					break;
				case 'L':
					direction--;
					break;
				case 'R':
					direction++;
					break;
				default:
					break;
				}
				if(direction==4){
					direction=0;
				}else if(direction==-1){
					direction=3;
				}
					
				maxx=Math.max(maxx, xpos);
				maxy=Math.max(maxy, ypos);

				minx=Math.min(minx, xpos);
				miny=Math.min(miny, ypos);
			}
			
			int answer=(maxx-minx)*(maxy-miny);
			System.out.println(answer);
		}
		
	}

}
