import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n ,m;
	static int[]arr;
	static int[]sel;
	static boolean[]visit;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		sb = new StringBuilder();
		arr = new int[n];
		sel = new int[m];
		visit = new boolean[n];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}
	//조합(재귀할때 인덱스 값 변경)
	public static void perm(int idx) {
		if(idx == m) {
			for(int i=0; i<m; i++) {
				sb.append(sel[i]+" "); //현재 수들 새로운 스트링빌더에 저장
			}
			sb.append("\n");
			return;
		}
		
		boolean [] used = new boolean[10001];
		
		for(int i=0; i<n; i++) {
			if(!visit[i] && !used[arr[i]]) {
				sel[idx] = arr[i];
				
				
				visit[i] = true;
				used[arr[i]]=true;
				perm(idx+1);
				visit[i] = false;
			}
		}
	}
}