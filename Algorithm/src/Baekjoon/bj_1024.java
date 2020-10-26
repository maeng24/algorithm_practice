package Baekjoon;
import java.util.Scanner;

public class bj_1024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double L = sc.nextDouble();
		int ans=-1;
		int[] arr= null;
		for(double i=L;i<=100;i++) {
			int n=(int) (Math.ceil((N/i))-(int)(i/2));
					if(n>=0&&(((2*n)+(i-1))/2)*i==N) {
						arr=new int[(int)i];
						arr[0]=n;
						ans=(int)i;
						break;
					}
				}
			
		if(ans==-1) {
			System.out.println("-1");
		}
		else {
			System.out.print(arr[0]+" ");
			for(int i=1;i<ans;i++) {
				arr[i]=arr[i-1]+1;
				System.out.print(arr[i]+" ");
			}	
		}
		
	}

}