import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 설탕의 무게
		int[]p = new int[n];
		for (int i = 0; i <n; i++) {
			p[i] = sc.nextInt();
		}
		Arrays.sort(p);
		int sum = 0;
		for(int i=1;i<n; i++) {
			p[i] += p[i-1];
			sum += p[i];
		}
		System.out.println(sum+p[0]);
	}
}