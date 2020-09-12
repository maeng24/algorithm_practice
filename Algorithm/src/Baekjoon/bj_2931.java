package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2931 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int xx=0,yy=0;
		int[] arr2 = new int[4];
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		int x=Integer.parseInt(tk.nextToken());
		int y=Integer.parseInt(tk.nextToken());
		char[][] arr=new char[x+1][y+1];
		boolean[][] check=new boolean[x+1][y+1];
		boolean ans=false;

		for(int i=1;i<=x;i++) {
			String str=br.readLine();
			for(int j=1;j<=y;j++) {
				arr[i][j]=str.charAt(j-1);
			}
		}
		for(int a=1;a<=x;a++) {
			for(int b=1;b<=y;b++) {
				if (check[a][b] == false) {
					check[a][b] = true;
					if (arr[a][b] == '.') {
						if (b>1&&(arr[a][b-1] == '1' || arr[a][b-1] == '2' || arr[a][b-1] == '-' || arr[a][b-1] == '+')) {
							arr2[0] = 1;
							ans=true;
						}if (a<x&&(arr[a+1][b] == '2' || arr[a+1][b] == '3' || arr[a+1][b] == '+'
								|| arr[a+1][b] == '|')) {
							arr2[1] = 1;
							ans=true;
						} if (b<y&&(arr[a][b+1] == '-' || arr[a][b+1] == '+' || arr[a][b+1] == '3'
								|| arr[a][b+1] == '4')) {
							arr2[2] = 1;
							ans=true;
						} if (a>1&&(arr[a-1][b] == '|' || arr[a-1][b] == '+' || arr[a-1][b] == '1'
								|| arr[a-1][b] == '4')) {
							arr2[3] = 1;
							ans=true;
						}
					}
				}
				if(ans==true) {
					xx=a;
					yy=b;
					break;
				}
			}
			if(ans==true) {
				break;
			}
		}
		if(arr2[0]==1&&arr2[1]==1&&arr2[2]==1) {
			System.out.println(xx+" "+yy+" +");
		}else{
			if(arr2[0]==1&&arr2[1]==1) {
				System.out.println(xx+" "+yy+" 4");
			}else if(arr2[1]==1&&arr2[2]==1) {
				System.out.println(xx+" "+yy+" 1");
			}else if(arr2[2]==1&&arr2[3]==1) {
				System.out.println(xx+" "+yy+" 2");
			}else if(arr2[0]==1&&arr2[3]==1) {
				System.out.println(xx+" "+yy+" 3");
			}else if(arr2[0]==1&&arr2[2]==1) {
				System.out.println(xx+" "+yy+" -");
			}else if(arr2[1]==1&&arr2[3]==1) {
				System.out.println(xx+" "+yy+" |");
			}
		}
	}
}

