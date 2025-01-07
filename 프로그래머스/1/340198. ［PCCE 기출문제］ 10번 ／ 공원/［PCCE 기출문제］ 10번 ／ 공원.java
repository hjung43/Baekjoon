import java.lang.Math;
import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int answer = -1;
        int high = park.length;
        int width = park[0].length;
        loop1: for(int t=mats.length-1; t>=0; t--){
            for(int h=0; h<high; h++){
                for(int w=0; w<width; w++){
                    if(park[h][w].equals("-1")){
                        if(h+mats[t]-1<high && w+mats[t]-1<width){
                            boolean isValid = true;
                            for (int i = 0; i < mats[t]; i++) {
                                for (int j = 0; j < mats[t]; j++) {
                                    if (!park[h + i][w + j].equals("-1")) {
                                        isValid = false;
                                        break;
                                    }
                                }
                                if (!isValid) break;
                            }
                            if (isValid) {
                                answer = mats[t];
                                return answer;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}