class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++){
            int score = 0;
            for(int j=0; j<photo[i].length; j++){
                String nowName = photo[i][j];
                for(int k=0; k<name.length; k++){
                    if(nowName.equals(name[k])){
                        score += yearning[k];
                    }
                }
            }
            // System.out.println(score);
            answer[i] = score;
        }
        

        return answer;
    }
}