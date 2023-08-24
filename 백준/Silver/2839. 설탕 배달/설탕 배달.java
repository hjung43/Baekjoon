import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[1001][1001];
		int n = sc.nextInt(); 
		if(n%5==0) {
			System.out.println(n/5);
		}else if(n%5 == 3) {
			System.out.println(n/5+1);
		}else {
			int q = n/5-1;
			while(q>0) {
				if((n-q*5)%3==0) {
					q +=(n-q*5)/3;
					System.out.println(q);
					return;
				}
				q--;
			}
			if(n%3==0) {
				System.out.println(n/3);
			}else {
				System.out.println(-1);
			}
		}
	}
}