import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = 1;
		StringBuilder sb = new StringBuilder();

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			if (!(st.isEmpty()) && st.peek() != k && t <= k) {
				for (int j = t; j <= k; j++) {
					st.push(t++);
					sb.append("+").append("\n");
				}
				st.pop();
				sb.append("-").append("\n");
			} else if (st.isEmpty()) {
				for (int j = t; j <= k; j++) {
					st.push(t++);
					sb.append("+").append("\n");
				}
				st.pop();
				sb.append("-").append("\n");
			} else if (st.peek() == k) {
				st.pop();
				sb.append("-").append("\n");
			} else {
				System.out.println("NO");
				t = -1;
				break;
			}
		}
		if (t != -1) {
			System.out.println(sb);
		}
	}

}