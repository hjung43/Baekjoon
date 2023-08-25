

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수 입력
		// 테스트 케이스 만큼 반복
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); //저수지 크기 입력
			String[][]r = new String [n+2][n+2];
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					r[i][j] = sc.next(); 
				}
			}
			//델타 (좌상 상 우상 우 우하 하 좌하 좌)
			int[]dr = {1,1,1,0,-1,-1,-1,0};
			int[]dc = {-1,0,1,1,1,0,-1,-1};
			int result = 0;
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(r[i][j].equals("W")){
						int cnt =0;
						for(int k=0; k<8; k++) {
							String d = r[i+dr[k]][j+dc[k]];
							if(d != null && d.equals("W")) {
								cnt++;
							}
						}
						if(cnt>result) {
							result = cnt;
						}else if(cnt==0) {
							result = 1;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",t,result);

		}
	}
}