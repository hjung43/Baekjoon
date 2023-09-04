import java.util.Scanner;

public class Main {
	static char[][]arr; //트리 정보 담을 배열
	static int n; //트리의 노드개수 담을 변수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //노드 개수 입력
		arr = new char[n][3]; //노드 개수만큼 배열 크기 선언
		//배열에 노드 담기
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.next().charAt(0); //부모노드
			arr[i][1] = sc.next().charAt(0); //왼쪽자식 노드
			arr[i][2] = sc.next().charAt(0); //오른쪽 자식 노드
		}
		preorder(0); //전위순회 함수
		System.out.println();
		inorder(0); //중위순회 함수
		System.out.println();
		postorder(0); //후위순회 함수
	}
	//전위순회 함수
	public static void preorder(int idx) {
		if(idx<n) { //인덱스가 n보다 작을때만 실행(배열 인덱스 안에서만 실행)
			System.out.print(arr[idx][0]); //루트 출력(전위순회니까 부모부터 출력)
			//왼쪽자식 노드 인덱스 찾기
			for(int i=0; i<n; i++) {
				if(arr[i][0]==arr[idx][1]) { //현재 인덱스의 왼쪽자식 노드값을 가진 부모노드가 있으면
					preorder(i); //해당 노드 인덱스 호출
				}
			}
			for(int i=0; i<n; i++) {
				if(arr[i][0]==arr[idx][2]) {
					preorder(i);
				}
			}
		}
	}
	public static void inorder(int idx) {
		if(idx<n) {
			for(int i=0; i<n; i++) {
				if(arr[i][0]==arr[idx][1]) {
					inorder(i);
				}
			}
			System.out.print(arr[idx][0]);
			for(int i=0; i<n; i++) {
				if(arr[i][0]==arr[idx][2]) {
					inorder(i);
				}
			}
		}
	}
	public static void postorder(int idx) {
		if(idx<n) {
			for(int i=0; i<n; i++) {
				if(arr[i][0]==arr[idx][1]) {
					postorder(i);
				}
			}
			for(int i=0; i<n; i++) {
				if(arr[i][0]==arr[idx][2]) {
					postorder(i);
				}
			}
			System.out.print(arr[idx][0]);
		}
	}

}