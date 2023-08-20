import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][]arr = new int [m][n];
		
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
			
		int r = 0;
		int c = 0;
		int k = 0;
		int j =2;
		arr[r][c] =1;
		
		while(j != m*n+1) {
			int nr = r + dr[k%4];
			int nc = c + dc[k%4];
			if(nc<n && nc>=0 && nr<m && nr>=0 && arr[nr][nc] ==0) {
				r = nr;
				c = nc;
				arr[r][c]=j++;
				
			} else {
				k++;
			}
		}
		System.out.println(k);
		
	}
}