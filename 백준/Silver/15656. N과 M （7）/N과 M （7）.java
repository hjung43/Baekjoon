import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	//순열(visit 배열 사용 X)
	public static void perm(int idx) {
		if(idx == m) {
			for(int i=0; i<m; i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				sel[idx] = arr[i];
				perm(idx+1);
			}
		}
	}
}