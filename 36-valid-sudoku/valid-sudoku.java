class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        for(int i=0; i<n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                char cellVal = board[i][j];
                
                if(cellVal == '.')
                    continue;
                
                if(rows[i].contains(cellVal))
                    return false;
                rows[i].add(cellVal);
                
                if(cols[j].contains(cellVal))
                    return false;
                cols[j].add(cellVal);
                
                int box = 3*(i/3)+(j/3);
                if(boxes[box].contains(cellVal))
                    return false;
                boxes[box].add(cellVal);
            }
        }
        return true;
    }
}   