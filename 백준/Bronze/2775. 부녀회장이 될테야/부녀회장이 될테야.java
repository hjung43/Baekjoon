import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[][] apt = new int[k + 1][n + 1];
			int result = 0;
			int num = 1;
			for (int i = 1; i <= n; i++) {
				apt[0][i] = num++;
			}
			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
				}
			}
			if (k == 0) {
				System.out.println(apt[0][n]);
				break;
			}
			while (n > 0) {
				result += apt[k - 1][n--];
			}
			System.out.println(result);
		}
	}
}