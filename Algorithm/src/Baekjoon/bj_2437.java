package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2437 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] weightpend = new int[num];
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < num; i++) {
			weightpend[i] = Integer.parseInt(tk.nextToken());
		}

		Arrays.sort(weightpend);

		int sumweight = 0;
		
		//무게를 구한다.
		for (int i = 0; i < num; i++) {
			//sumweight+1보다 같거나 작은 수까지 측정할 수 있다. (무게추의 무게가 1이상이라고 가정 했을 때 +1) 
			if (sumweight + 1 >= weightpend[i]) { //이하의 숫자는 모두 측정가능했으므로 weightpend를 더한 만큼도 가능
				sumweight+=weightpend[i];
			}else{
				break;
			}
		}
		
		System.out.println(sumweight+1);
	}

}
