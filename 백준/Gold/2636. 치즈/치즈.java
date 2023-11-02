import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m;
	static int[][] cheese;
	static int[][] ncheese;
	static Queue<int[]> q;
	static int result, ch;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cheese = new int[n][m];
		ncheese = new int[n][m];
		
		int c = 0;
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j]==1) {
					c++;
				}
			}
		}
//		System.out.println("c "+c);
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(cheese[i][j]);
//			}System.out.println();
//		}
		result = 0;
		ch = c;
		while(c>0) {
			result++;
			loop1: for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(cheese[i][j]==0) {
//						System.out.println(i+" "+j);
						bfs(i,j);
						break loop1;
					}
				}
			}
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(cheese[i][j]);
//				}System.out.println();
//			}
//			System.out.println();
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(cheese[i][j]==1) {
//						System.out.println(i+" "+j);
						int air = 0;
						for(int d=0; d<4; d++) {
							int nr = i+dr[d];
							int nc = j+dc[d];
//							System.out.println("nrnc"+" "+nr+" "+nc);
							if(nr>=0 && nr<n && nc>=0 && nc<m && cheese[nr][nc]==2) {
//								System.out.println("00");
								air++;
							}
						}
						if(air>=1) {
//							System.out.println(air);
//							System.out.println(i+" "+j);
							c--;
						}else {
//							System.out.println("11");
							ncheese[i][j]=1;
						}
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				cheese[i] = ncheese[i].clone();
			}
			for(int i=0; i<n; i++) {
				Arrays.fill(ncheese[i], 0);
			}
		if(c!=0) {
			ch = c;
		}
//		System.out.println(result);
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(cheese[i][j]);
//			}System.out.println();
//		}System.out.println();
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(ncheese[i][j]);
//			}System.out.println();
//		}System.out.println();
	    }
		System.out.println(result);
		System.out.println(ch);

		
	}
	public static void bfs(int r, int c) {
		q = new LinkedList<>();
		q.add(new int[] {r,c});
		cheese[r][c]=2;
		
		while(!q.isEmpty()) {
			int[]tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nr = tmp[0]+dr[i];
				int nc = tmp[1]+dc[i];
				if(nr>=0 && nr<n && nc >=0 && nc<m && cheese[nr][nc]==0) {
					cheese[nr][nc] = 2;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}

}