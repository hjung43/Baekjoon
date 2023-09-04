import java.util.Scanner;

public class Solution {
	static int d; // 행
	static int w; // 열
	static int k; // 합격기준
	static int[][] film;
	static int[][] result;
	static int cnt;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			cnt = 0;
			d = sc.nextInt();
			w = sc.nextInt();
			k = sc.nextInt();
			film = new int[d][w];
			result = new int[d][w];
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					film[i][j] = sc.nextInt();
				}
			}
			test(0);
			System.out.println("#" + t + " " + ans);
		}

	}

	public static void test(int idx) {
		if (idx == d) {
			int total = 0;
			for (int i = 0; i < w; i++) {
				int sumA = 0;
				int sumB = 0;
				for (int j = 0; j < d; j++) {
					if (result[j][i] == 0) {
						sumA++;
						sumB = 0;
					} else if (result[j][i] == 1) {
						sumB++;
						sumA = 0;
					}
					if (sumA == k || sumB == k) {
						total++;
						break;
					}
				}
			}

			if (total == w && ans > cnt) {
				ans = cnt;
			}
			return;
		}
		for (int i = 0; i < w; i++) {
			result[idx][i] = film[idx][i];
		}
		test(idx + 1);
		if (ans > cnt + 1) {
			for (int i = 0; i < w; i++) {
				result[idx][i] = 0;
			}
			cnt++;
			test(idx + 1);
			cnt--;
		}
		if (ans > cnt + 1) {
			for (int i = 0; i < w; i++) {
				result[idx][i] = 1;
			}
			cnt++;
			test(idx + 1);
			cnt--;
		}
	}

}

