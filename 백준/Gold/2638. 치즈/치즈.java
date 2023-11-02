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
	static int[][] cheese; //치즈 담을 배열
	static int[][] ncheese; //1시간 후 치즈 담을 배열
	static Queue<int[]> q;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cheese = new int[n][m]; 
		ncheese = new int[n][m];

		int c = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				//치즈 개수 세기
				if (cheese[i][j] == 1) {
					c++;
				}
			}
		}
		result = 0; //치즈가 다녹는 시간 저장할 변수
		//치즈가 다 녹기 전까지 반복
		while (c > 0) {
			result++; //한시간 지났을때
			loop1: for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					//공기(0)(갇혀있는 공기 제외) 다 2로 만들기
					if (cheese[i][j] == 0) {
						bfs(i, j);
						break loop1;
					}
				}
			}
			//완전탐색
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					//치즈가 있으면
					if (cheese[i][j] == 1) {
						int air = 0; //치즈 주변이 있는 공기 저장할 개수
						//치즈 주변 공기 개수 찾기
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if (nr >= 0 && nr < n && nc >= 0 && nc < m && cheese[nr][nc] == 2) {
								air++;
							}
						}
						//공기가 2개 이상이면
						if (air >= 2) {
							c--; //치즈 수 하나 빼기
						} else { //아니면
							//다음날 치즈 배열에 치즈 넣기
							ncheese[i][j] = 1;
						}
					}
				}
			}
			//다음날 치즈 cheese배열에 복사하기
			for (int i = 0; i < n; i++) {
				cheese[i] = ncheese[i].clone();
			}
			//ncheese배열 0으로 초기화
			for (int i = 0; i < n; i++) {
				Arrays.fill(ncheese[i], 0);
			}
		}
		//결과값 출력
		System.out.println(result);

	}
	//갇혀있지 않은 공기 모두 2로 바꾸는 bfs
	public static void bfs(int r, int c) {
		q = new LinkedList<>();
		q.add(new int[] { r, c });
		cheese[r][c] = 2;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
                //현재 위치가 배열안에 있고 갇혀있지 않은 공기이면
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && cheese[nr][nc] == 0) {
                    //2로 바꾸기
                    cheese[nr][nc] = 2;
					q.add(new int[] { nr, nc });
				}
			}
		}
	}

}