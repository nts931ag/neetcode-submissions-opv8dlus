class Solution {
    public boolean isValidSudoku(char[][] board) {
    Map<Integer, Set<Character>> rows = new HashMap<>();
    Map<Integer, Set<Character>> cols = new HashMap<>();
    Map<String, Set<Character>> subBoxes = new HashMap<>();

    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < 9; ++j) {
            char c = board[i][j];
            if (Character.isDigit(c)) {
                String subBoxesIdx = (i / 3) + "," + (j / 3);
                
                if (!rows.computeIfAbsent(i, k -> new HashSet<>()).add(c) ||
                    !cols.computeIfAbsent(j, k -> new HashSet<>()).add(c) ||
                    !subBoxes.computeIfAbsent(subBoxesIdx, k -> new HashSet<>()).add(c)) {
                    return false;
                }
            }
        }
    }
    return true;
}
}
