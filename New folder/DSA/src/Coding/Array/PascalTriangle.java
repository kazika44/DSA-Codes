package Coding.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            int value = 1;
            row.add(value);
            for (int j = 1; j < i; j++) {
                value = value * (i - j) / j;
                row.add(value);
            }
            result.add(row);
        }
        return result;
    }
    public static void main(String[] args) {
        PascalTriangle triangle = new PascalTriangle();
        int numRows = 5;
        List<List<Integer>> result = triangle.generate(numRows);
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for (List<Integer> row : result) {
            System.out.println(row);

        }
    }
}
