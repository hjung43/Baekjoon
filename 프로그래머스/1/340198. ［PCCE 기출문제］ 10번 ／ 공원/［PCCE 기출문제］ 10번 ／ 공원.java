import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 결과값을 저장할 변수를 초기화
        int result = -1;
        
        // 매트를 크기순으로 정렬
        Arrays.sort(mats);
        int n = park.length; // 공원의 행 크기
        int m = park[0].length; // 공원의 열 크기
        
        // 공원의 모든 좌표를 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 공원 좌표가 '-1'일 때, 해당 좌표에서 시작할 수 있는 가장 큰 매트 크기를 찾는다
                if (park[i][j].equals("-1")) {
                    result = Math.max(getMaxSize(mats, park, i, j), result);
                    
                    // 만약 가장 큰 매트가 놓여질 수 있다면 탐색을 종료하고 결과를 반환
                    if (result == mats[mats.length-1])
                        return result;
                }
            }
        }
        
        return result;
    }
    
    public int getMaxSize(int[] mats, String[][] park, int x, int y) {
        // 현재 위치에서 가장 큰 매트 크기를 저장할 변수
        int maxSize = -1;
        int n = park.length; // 공원의 행 크기
        int m = park[0].length; // 공원의 열 크기
        
        // 가장 큰 매트 크기부터 작은 매트 크기까지 순차적으로 검사
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i]; // 현재 검사 중인 매트의 크기
            
            // 매트가 공원 범위를 벗어나면 검사하지 않는다
            if (x + size - 1 >= n || y + size - 1 >= m)
                continue;
            
            boolean flag = true; // 매트를 놓을 수 있는지 여부를 저장할 플래그
            
            // 매트를 놓을 범위의 공원 좌표를 검사
            for (int j = x; j < x + size; j++) {
                for (int k = y; k < y + size; k++) {
                    // 공원의 해당 좌표가 '-1'이 아닌 경우, 매트를 놓을 수 없다
                    if (!park[j][k].equals("-1")) {
                        flag = false;
                        break;
                    }
                }
            }
            
            // 매트를 놓을 수 있는 경우, 해당 매트의 크기를 저장하고 종료
            if (flag) {
                maxSize = size;
                break;
            }
        }
        
        return maxSize; // 놓을 수 있는 가장 큰 매트 크기를 반환
    }
}
