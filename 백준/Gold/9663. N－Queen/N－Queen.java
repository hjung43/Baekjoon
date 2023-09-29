import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, result;
	static boolean[][] chess;
	static int[] d = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		chess = new boolean[n][n];
		result = 0;

		perm(0);
		System.out.println(result);

	}

	public static void perm(int i) { // r은 열
		if (i == n) {
			result++;
			return;
		}
		for (int j = 0; j < n; j++) {
			int cnt = 0;
			for (int k = 0; k < 3; k++) {
				int nr = i - 1;
				int nc = j + d[k];
				while (nr >= 0 && nc >= 0 && nr < n && nc < n) {
					if (chess[nr][nc] == true) {
						cnt++;
						break;
					}
					nr--;
					nc += d[k];
				}
			}
			if (cnt == 0) {
				chess[i][j] = true;
				perm(i + 1);
				chess[i][j] = false;
			}
		}
	}
}