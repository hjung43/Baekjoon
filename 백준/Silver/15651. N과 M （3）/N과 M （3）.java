import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n ,m;
	static int[]arr;
	static int[]sel;
	static boolean[]visit;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[n];
		sel = new int[m];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		perm(0);
		System.out.println(sb);
	}
	//순열에서 boolean배열 제외
	public static void perm(int idx) {
		if( idx == m) {
			for(int i=0; i<m; i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
			sel[idx] = arr[i];
			perm(idx+1);
		}
	}
}