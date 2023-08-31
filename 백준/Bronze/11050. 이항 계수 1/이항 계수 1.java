import java.util.Scanner;

public class Main {
	public static int n;
	public static int k;
	public static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		comb(0,0);
		System.out.println(result);
	}
	public static void comb(int idx, int sidx) {
		if(sidx == k) {
			result ++;
			return;
		}
		if(idx == n) return;
		
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}

}