package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2630 {
	static int num;
	static int[][] paper;
	static int blue, white;
	
	//종이가 모두 같은 색인지 확인
	public static boolean checksame(int n, int x, int y){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(paper[y][x]!=paper[y+i][x+j]){
					return false;
				}
			}
		}
		return true;
	}
	
	//종이의 색을 확인후 나누거나 센다
	public static void checkpaper(int n, int x, int y){
		
		if(checksame(n,x,y)){
			if(paper[y][x]==1){
				blue++;
			}else{
				white++;
			}
		}else{
			int divide=n/2;
			for(int i=0;i<2;i++){
				for(int j=0;j<2;j++){
					checkpaper(divide, x+(i*divide), y+(j*divide));
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		num=Integer.parseInt(br.readLine());

		paper=new int[num][num];
		
		StringTokenizer tk=null;
		
		for(int i=0;i<num;i++){
			tk=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<num;j++){
				paper[i][j]=Integer.parseInt(tk.nextToken());
			}
		}
		
		checkpaper(num, 0, 0);
		System.out.println(white+"\n"+blue);
	}

}
