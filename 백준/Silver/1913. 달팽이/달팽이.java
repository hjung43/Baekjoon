import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int [m][m];
		
		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};
		
		int r = 0;
		int c = 0;
		int j = m*m;
		int k = 0;  //방향
		arr[0][0] = j--;
		int ni = 1;  //n위치
		int nj = 1;  //n위치
		
		while(j>0) {
			int nr = r + dr[k%4];
			int nc = c + dc[k%4];
			if(nr>=0 && nr<m&& nc>=0 && nc<m && arr[nr][nc]==0) {
				r = nr;
				c = nc;
				arr[r][c]= j--;
				if(arr[r][c] == n) {
					ni = r+1;
					nj = c+1;
				}
			}else {
				k++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			for(int l=0; l<m; l++) {
				sb.append(arr[i][l]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		System.out.print(ni+" "+nj);
	}
}