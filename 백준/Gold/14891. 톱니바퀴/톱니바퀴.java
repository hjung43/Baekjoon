import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] wheel = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = str.charAt(j) - '0';
			}
		}
		int[] start = new int[4];
		Arrays.fill(start, 104); // n이 100이하이기 때문에 100을 넘는 8의 배수 넣기(나머지 연산 하려고)
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int turn = Integer.parseInt(st.nextToken());
			int[] nStart = start.clone();

			if (num < 3) {
				int nnum = num;
				while (nnum + 1 <= 3 && wheel[nnum][(start[nnum] + 2) % 8] != wheel[nnum + 1][(start[nnum + 1] - 2) % 8]) {
					if(num%2 == nnum%2)
					nStart[nnum + 1] = start[nnum + 1] - (turn * -1);
					else if(num%2!=nnum%2)
						nStart[nnum + 1] = start[nnum + 1] - turn;
					nnum++;
				}
					
			}
			if (num > 0) {
				int nnum = num;
//				System.out.println(wheel[nnum][(start[nnum] - 2) % 8]+" "+wheel[nnum - 1][(start[nnum - 1] + 2) % 8]);
				while (nnum - 1 >= 0 && wheel[nnum][(start[nnum] - 2) % 8] != wheel[nnum - 1][(start[nnum - 1] + 2) % 8]) {
					if(num%2 == nnum%2)
						nStart[nnum - 1] = start[nnum - 1] - (turn * -1);
					else if(num%2!=nnum%2)
						nStart[nnum - 1] = start[nnum - 1] - turn;
					nnum--;
				}
			}
		
			start = nStart.clone();
			start[num] = start[num] - turn;

		}
//		System.out.println(Arrays.toString(start));
//		for (int i = 0; i < 4; i++) {
//			System.out.print(start[i] % 8 + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < 4; i++) {
//			System.out.print(wheel[i][start[i] % 8]);
//		}
//		System.out.println();
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			if (wheel[i][start[i] % 8] == 1) {
				if (i == 0)
					ans += 1;
				if (i == 1)
					ans += 2;
				if (i == 2)
					ans += 4;
				if (i == 3)
					ans += 8;
			}
		}
		System.out.println(ans);
	}

}