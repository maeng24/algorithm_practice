package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14719 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(tk.nextToken());
		int W = Integer.parseInt(tk.nextToken());

		int[] blocks = new int[W];
		int highestheight = 0, highestpoint = 0;
		
		tk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < W; i++) {
			blocks[i] = Integer.parseInt(tk.nextToken());
			if (blocks[i] > highestheight) {
				highestheight = blocks[i];
				highestpoint = i;
			}
		}

		//왼쪽 부분 탐색
		int answer=0;
		int firstheight = highestheight, firstpoint = highestpoint;
		int secondheight = -1, secondpoint = -1;
		boolean flag=true;
		while (flag) {
			flag=false;
			for(int i=firstpoint-1;i>=0;i--){
				if(secondheight<blocks[i]){
					secondheight=blocks[i];
					secondpoint=i;
					flag=true;	
				}
			}
			
			for(int i=secondpoint+1;i<firstpoint;i++){
				answer+=(secondheight-blocks[i]);
			}
			
			firstheight=secondheight;
			firstpoint=secondpoint;
			secondheight=blocks[0];
			secondpoint=0;
		}

		//오른쪽 부분 탐색
		firstheight = highestheight; 
		firstpoint = highestpoint;
		secondheight = -1;
		secondpoint = -1;
		flag=true;
		while (flag) {
			flag=false;
			for(int i=firstpoint+1;i<W;i++){
				if(secondheight<blocks[i]){
					secondheight=blocks[i];
					secondpoint=i;
					flag=true;	
				}
			}
			
			for(int i=firstpoint+1;i<secondpoint;i++){
				answer+=(secondheight-blocks[i]);
			}
			
			firstheight=secondheight;
			firstpoint=secondpoint;
			secondheight=blocks[W-1];
			secondpoint=W-1;
		}
		
		System.out.println(answer);
	}

}
