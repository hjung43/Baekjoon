import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mushroom = new int[11];
		int[]sum = new int[11];
		int result = 0;
		for(int i=1; i<=10; i++) {
			mushroom[i] = sc.nextInt();
			sum[i] = sum[i-1]+mushroom[i];
		}
		for(int i=1; i<=10; i++) {
			if(Math.abs(100-sum[i])<Math.abs(100-result)) {
				result = sum[i];
			} else if (Math.abs(100-sum[i])==Math.abs(100-result)) {
				if(sum[i]>result) {
					result = sum[i];
				}
			}
		}System.out.println(result);
	}
}