import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[]N = new int[n];
		
		for(int a =0; a<n; a++) {
			N[a]=a+1;
		}
		for(int b =0; b<m; b++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int temp = N[i-1];
			N[i-1] = N[j-1];
			N[j-1] = temp;
		}
		for(int c : N) {
			System.out.print(c+" ");
		}
	}
}