import java.util.Scanner;

public class Solution {
	public static int[]arr = new int[1000000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			int T = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.println("#"+T+" "+power(n,m));
		}
	}
	public static int power (int x,int n) {
		if(n==1) return x;
		if(n%2==0) {
			int r = power(x,n/2);
			return r*r;
		}else {
			int r = power(x,(n-1)/2);
			return r*r*x;
		}
	}

}