import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[10];
		int result = 0;

		for (int i = 0; i < 10; i++) {
			int a = sc.nextInt();
			nums[i] = a % 42;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				if (nums[i] ==42) {
					break;
				}
				if (nums[i] == nums[j]) {
					nums[j]=42;
				}
			}

		}
		for(int i : nums) {
			if (i!=42)
				result += 1;
		}
		System.out.println(result);

	}

}