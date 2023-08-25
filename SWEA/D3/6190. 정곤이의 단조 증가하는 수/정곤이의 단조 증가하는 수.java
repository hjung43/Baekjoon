import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수 입력
		// 테스트 케이스 만큼 반복
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); //수의 개수 입력
			int[] arr = new int[n]; //수의 개수 크기로 배열 생성
            //배열에 수 입력
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int result = -1; //결과값(단조증가하는 수의 최댓값)저장하는 변수
            //두수의 곱 중 단조증가하는 수 찾기
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					char[]d = (arr[i] * arr[j]+"").toCharArray();  //두 수의 곱을 한자리씩 문자배열에 저장
					boolean r = false; //단조증가인지 아닌지 판별하는 변수
					for (int k = 0; k < d.length - 1; k++) {
						if (d[k]+'0' <= d[k + 1]+'0') { //두수의 곱중 더 큰자리수의 값이 작은자리수의 값 보다 작거나 같으면
							r = true; //단조증가하는 수
						} else { //두 수의 곱값에서 더 큰 자리수의 값이 작은 자리수의 값 보다 크면
							r = false; //단조증가 하는 수 아님
							break; //반복문 중지
						}

					}
                    //단조증가 하는 수이고 결과값보다 현재의 곱 값이 더 크다면
					if (r && result < arr[i] * arr[j]) {
						result = arr[i] * arr[j]; //결과값 변경
					}
				}
			}
            //결과값 출력
			System.out.println("#" + t + " " + result);
		}
	}
}