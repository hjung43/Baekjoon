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
		perm(0);
	}
	//그냥 순열인데 결과값이 m이되면 그냥 리턴함
	public static void perm(int idx) {
		if( idx == m) {
			for(int i=0; i<m; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				sel[idx] = arr[i];
				visit[i] = true;
				perm(idx+1);
				visit[i] = false;
			}
		}
	}
}