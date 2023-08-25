import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수 입력
		// 테스트 케이스 만큼 반복
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int result = -1;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					char[]d = (arr[i] * arr[j]+"").toCharArray();
					boolean r = false;
					for (int k = 0; k < d.length - 1; k++) {
						if (d[k]+'0' <= d[k + 1]+'0') {
							r = true;
						} else {
							r = false;
							break;
						}

					}
					if (r && result < arr[i] * arr[j]) {
						result = arr[i] * arr[j];
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}