import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[] arr1 = new int[6];
		int[] arr2 = new int[6];
		for (int i = 0; i < 6; i++) {
			arr1[i] = sc.nextInt();
			arr2[i] = sc.nextInt();

		}

		int i = 1;
		int s = 0;
		int r = 0;
		int c = 0;
		for (int j = 0; j < 6; j++) {
			if ((arr1[j] == 1 || arr1[j] == 2) && arr2[j] > r) {
				r = arr2[j];
			}
			if ((arr1[j] == 3 || arr1[j] == 4) && arr2[j] > c) {
				c = arr2[j];
			}
		}
		int S = r * c;
		while (i < 13) {
			if (arr1[i % 6] == arr1[(i + 2) % 6]) {
				if (arr1[(i - 1) % 6] == arr1[(i + 1) % 6]) {
					s = arr2[i % 6] * arr2[(i + 1) % 6];
				} else {
					s = arr2[(i + 1) % 6] * arr2[(i + 2) % 6];
				}
				break;
			}
			i++;
		}
		System.out.println((S - s) * k);
	}
}