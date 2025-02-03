import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0; 
        int n = board.length;   // 열 수(세로)
        int m = board[0].length;    // 행 수(가로)
        int [][] prefix_arr = new int[n+1][m+1];    
        // 변화량 기록할 2차원 배열, 누적합 계산 위해 n+1, m+1
        
        for (int [] row : skill){   
            // 각 skill 적용(공격 or 수비)
            int type = row[0];
            int degree = type == 1 ? -row[5] : row[5];
            // type에 따라 degree 저장
            int r1 = row[1];    // 시작 (r1, c1)
            int c1 = row[2];
            int r2 = row[3];    // 끝 (r2, c2)
            int c2 = row[4];
            
            for (int i=r1; i<=r2; i++) {
                // 변화량 기록(행 단위), 아래와 같은 느낌
                //  0   0   0   0   0   0  
                //  0  -2   0   0   0   2  
                //  0  -2   0   0   0   2  
                //  0  -2   0   0   0   2  
                //  0   0   0   0   0   0  
                prefix_arr[i][c1] += degree;
                prefix_arr[i][c2+1] += -degree;
                // c2+1에 하는 이유는, 이후 prefix_arr를 가로로 확장할 때 해당 범위까지 적용이 되기 때문.
                // ex) +2 -2 = 0 이런 식으로 상쇄
                // 상쇄시켜야지만 범위의 바로 다음 값이 0이 되어 그 다음 열에 영향을 안 줌.
            }
            
        for (int i=0; i<n; i++){    // 행 하나씩
            for (int j=0; j<m; j++){    // 열 하나씩
                if (j!=0)
                    prefix_arr[i][j] += prefix_arr[i][j-1]; // 위에서 행 단위로 기록한 변화량을 가로로 확장!
                //  0   0   0   0   0   0  
                //  0  -2  -2  -2  -2   0  
                //  0  -2  -2  -2  -2   0  
                //  0  -2  -2  -2  -2   0  
                //  0   0   0   0   0   0
                board[i][j] += prefix_arr[i][j];    // 변화량을 board에 적용(각 [i][j] index마다!)
                if (board[i][j]>0)  // board에서 내구도 1 이상인 애들은 살아남은 애들이므로 바로 answer에 적용(확정)
                    answer++;
            }
        }
        
        return answer;
    }
}
