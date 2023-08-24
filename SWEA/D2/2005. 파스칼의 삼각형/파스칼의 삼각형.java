import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] arr1 = new int[n + 2];
			int[] arr2 = new int[n + 2];
			arr1[1] = 1;
			System.out.println("#"+t);
			System.out.println(arr1[1]);
			int k = 2;
			for (int i = 0; i < n-1; i++) {
				for (int j = 1; j < n+2; j++) {
					arr2[j] = arr1[j - 1] + arr1[j];
				}
				for (int j = 0; j < n+2; j++) {
					arr1[j] = arr2[j];
				}
				for(int j=1; j<=k; j++) {
					System.out.print(arr1[j]+" ");
				}System.out.println();
				k++;
			}
		}
	}
}