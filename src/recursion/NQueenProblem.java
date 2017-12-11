package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenProblem {

//    坐标(row, col)
    class Position {
        int row, col;
        Position (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Position[] solveNQueenOneSolution(int n) {
        Position[] positions = new Position[n];
        boolean hasSolution = solveNQueenOneSolutionUtil(n, 0, positions);
        if(hasSolution) {
            return positions;
        }
        else {
            return new Position[0];
        }
    }


//    position记录皇后放的位置
    private boolean solveNQueenOneSolutionUtil(int n, int row, Position[] positions) {
        if(n == row) {
            return true;
        }

        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;

            for (int queen = 0; queen < row; queen++) {

                if(positions[queen].col == col || positions[queen].row -
                        positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }

            if(foundSafe) {
                positions[row] = new Position(row, col);
                if(solveNQueenOneSolutionUtil(n, row+1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }





//    solve for https://leetcode.com/problems/n-queens/description/

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Position[] positions = new Position[n];
        solve(n, 0, positions, result);
        return result;
    }

    public void solve(int n, int curRow, Position[] positions, List<List<String>> result) {
        if(n == curRow) {
            StringBuffer buffer = new StringBuffer();
            List<String> oneResult = new ArrayList<>();
            for (Position p : positions) {
                for (int i = 0; i < n; i++) {
                    if(p.col == i) {
                        buffer.append("Q");
                    }
                    else {
                        buffer.append(".");
                    }
                }
                oneResult.add(buffer.toString());
                buffer = new StringBuffer();
            }

            result.add(oneResult);
            return;
        }


        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;

            for (int queen = 0; queen < curRow; queen++) {

                if(positions[queen].col == col ||
                        positions[queen].col - positions[queen].row == col - curRow ||
                        positions[queen].col + positions[queen].row == col + curRow) {
                    foundSafe = false;
                    break;
                }

            }

            if(foundSafe) {
                positions[curRow] = new Position(curRow, col);
                solve(n, curRow+1, positions, result);
            }
        }
    }


    public static void main(String[] args) {
        NQueenProblem s = new NQueenProblem();
//        Position[] positions = s.solveNQueenOneSolution(4);
        List<List<String>> lists = s.solveNQueens(4);
        for (List<String> list: lists) {
            for (String p: list) {
                System.out.println(p);
            }
            System.out.println();
        }

    }


}
