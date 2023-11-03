import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] price;
	static int[] use;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int result = 0;

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int pr = 0;
				int pc = 0;
				int prc = 0;
				if (i - 1 >= 0) {
					pr = arr[i - 1][j];
				}
				if (j - 1 >= 0) {
					pc = arr[i][j - 1];
				}
				if (i - 1 >= 0 && j - 1 >= 0)
					prc = arr[i - 1][j - 1];
				arr[i][j] = pr + pc + (Integer.parseInt(st.nextToken())) - prc;
			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(arr[i][j]+" ");
//			}System.out.println();
//		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken()) - 1;
			int sc = Integer.parseInt(st.nextToken()) - 1;
			int er = Integer.parseInt(st.nextToken()) - 1;
			int ec = Integer.parseInt(st.nextToken()) - 1;
			
			int pr= 0;
			int pc = 0;
			int prc = 0;
			
			if (sr - 1 >= 0) {
				pr = arr[sr - 1][ec];
			}
			if (sc - 1 >= 0) {
				pc = arr[er][sc - 1];
			}
			if (sr - 1 >= 0 && sc - 1 >= 0)
				prc = arr[sr - 1][sc - 1];
			result = arr[er][ec]-pr-pc+prc;
//			System.out.println(pr+" "+pc+" "+prc);
			System.out.println(result);

		}

	}
}