import java.util.Scanner;

public class Main {
	static int n ,m;
	static int[]arr;
	static int[]sel;
	static boolean[]visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		sel = new int[m];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		comb(0,0);
	}
	//조합
	public static void comb(int idx, int sidx) {
		if( sidx == m) {
			for(int i=0; i<m; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if(idx == n) {
			return;
		}
		sel[sidx] = arr[idx];
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}
}