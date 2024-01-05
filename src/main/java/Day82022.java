import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day82022 {

    public static void main(String[] args) throws IOException {
        //part 1
        List<String> lines = Files.readAllLines(new File("src/main/Day82022.txt").toPath());
        int rows = lines.size();
        int columns = lines.get(0).length();
        int[][] grid = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = Integer.parseInt(String.valueOf(lines.get(row).charAt(column)));
            }
        }
        int amount = 99 + 99 + 97 + 97;
        for (int row = 1; row < rows - 1; row++) {
            for (int column = 1; column < columns - 1; column++) {
                boolean above = checkAbove(row, column, grid);
                boolean beneath = checkBeneath(row, column, grid);
                boolean left = checkLeft(row, column, grid);
                boolean right = checkRight(row, column, grid);
                if (above || beneath || left || right) {
                    amount++;
                }
            }
        }
        System.out.println(amount);

        //part 2
        int amount2 = 0;
        for (int row = 1; row < rows - 1; row++) {
            for (int column = 1; column < columns - 1; column++) {
                int above = checkAbove2(row, column, grid);
                int beneath = checkBeneath2(row, column, grid);
                int left = checkLeft2(row, column, grid);
                int right = checkRight2(row, column, grid);
                int newAmount = above * beneath * left * right;
                if (newAmount > amount2) {
                    amount2 = newAmount;
                }
            }
        }
        System.out.println(amount2);
    }

    public static boolean checkAbove(int startRow, int startColumn, int[][] grid) {
        for (int row = startRow - 1; row >= 0; row--) {
            if (!(grid[row][startColumn] < grid[startRow][startColumn])) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkBeneath(int startRow, int startColumn, int[][] grid) {
        for (int row = startRow + 1; row <= 98; row++) {
            if (!(grid[row][startColumn] < grid[startRow][startColumn])) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkLeft(int startRow, int startColumn, int[][] grid) {
        for (int column = startColumn - 1; column >= 0; column--) {
            if (!(grid[startRow][column] < grid[startRow][startColumn])) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRight(int startRow, int startColumn, int[][] grid) {
        for (int column = startColumn + 1; column <= 98; column++) {
            if (!(grid[startRow][column] < grid[startRow][startColumn])) {
                return false;
            }
        }
        return true;
    }

    public static int checkAbove2(int startRow, int startColumn, int[][] grid) {
        int amount = 0;
        for (int row = startRow - 1; row >= 0; row--) {
            if (grid[row][startColumn] < grid[startRow][startColumn]) {
                amount++;
            } else if (grid[row][startColumn] == grid[startRow][startColumn]) {
                amount++;
                return amount;
            } else {
                return amount;
            }
        }
        return amount;
    }

    public static int checkBeneath2(int startRow, int startColumn, int[][] grid) {
        int amount = 0;
        for (int row = startRow + 1; row <= 98; row++) {
            if (grid[row][startColumn] < grid[startRow][startColumn]) {
                amount++;
            } else if (grid[row][startColumn] == grid[startRow][startColumn]) {
                amount++;
                return amount;
            } else {
                return amount;
            }
        }
        return amount;
    }

    public static int checkLeft2(int startRow, int startColumn, int[][] grid) {
        int amount = 0;
        for (int column = startColumn - 1; column >= 0; column--) {
            if (grid[startRow][column] < grid[startRow][startColumn]) {
                amount++;
            } else if (grid[startRow][column] == grid[startRow][startColumn]) {
                amount++;
                return amount;
            } else {
                return amount;
            }
        }
        return amount;
    }

    public static int checkRight2(int startRow, int startColumn, int[][] grid) {
        int amount = 0;
        for (int column = startColumn + 1; column <= 98; column++) {
            if (grid[startRow][column] < grid[startRow][startColumn]) {
                amount++;
            } else if (grid[startRow][column] == grid[startRow][startColumn]) {
                amount++;
                return amount;
            } else {
                return amount;
            }
        }
        return amount;
    }
}