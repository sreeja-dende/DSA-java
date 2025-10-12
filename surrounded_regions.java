class Solution {
    public void solve(char[][] board) {
       if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all border 'O's to the queue
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') queue.offer(new int[]{r, 0});
            if (board[r][cols - 1] == 'O') queue.offer(new int[]{r, cols - 1});
        }

        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') queue.offer(new int[]{0, c});
            if (board[rows - 1][c] == 'O') queue.offer(new int[]{rows - 1, c});
        }

        // Step 2: Mark all 'O's connected to the border as '#'
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];

            if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O') {
                continue;
            }

            board[r][c] = '#';
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                queue.offer(new int[]{newRow, newCol});
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O'; 
                }
            }
        }  
    }
}
