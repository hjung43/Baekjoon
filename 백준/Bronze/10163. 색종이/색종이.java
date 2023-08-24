import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[1001][1001];
		int n = sc.nextInt(); // 색종이의 수
		for (int t = 1; t <= n; t++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			int cp = sc.nextInt();
			int rp = sc.nextInt();
			r = 1001 - (r + rp - 1) - 1;
			for (int i = r; i < r + rp; i++) {
				for (int j = c; j < c + cp; j++) {
					arr[i][j] = t;
				}
			}
		}
		for (int k = 1; k <= n; k++) {
			int cnt = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if(arr[i][j]==k) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}