package co.uk.newday;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Diamond {
    //the size the matrix should be for each letter
    static final Map<Character, Integer> MATRIX_MAP_SIZE = new HashMap<>();
    static {
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'A') {
                MATRIX_MAP_SIZE.put(c, 1);
            } else {
                char previous = (char) (c - 1);
                Integer num = MATRIX_MAP_SIZE.get(previous);
                MATRIX_MAP_SIZE.put(c, num + 2);
            }
        }
    }

    private final Character chosenLetter;
    private final char[][] matrix;

    public Diamond(String letter) {
        assertChosenLetterIsValid(letter);
        this.chosenLetter = letter.toUpperCase().charAt(0);
        this.matrix = buildMatrix();
    }

    /**
     * Prints the diamond to System.out
     */
    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    /**
     * The diamond as a 2 dimensional array with no line breaks
     * @return
     */
    public char[][] getDiamondMatrix() {
        return matrix;
    }

    private char[][] buildMatrix() {
        int matrixSize = MATRIX_MAP_SIZE.get(this.chosenLetter);

        char[][] matrix = new char[matrixSize][matrixSize];
        int letterAColumnPosition = matrixSize / 2;
        int widestColumnPosition = matrixSize - 1;

        char c = 'A';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == 0) {
                    if (letterAColumnPosition == col) {
                        matrix[row][col] = c; //letter A
                    } else {
                        matrix[row][col] = ' ';
                    }
                } else {
                    if (row <= letterAColumnPosition) { //first half of diamond
                        if (col == letterAColumnPosition - row || col == letterAColumnPosition + row) {
                            matrix[row][col] = c;
                        } else {
                            matrix[row][col] = ' ';
                        }
                    } else { //other half
                        if (col == row - letterAColumnPosition) {
                            matrix[row][col] = c;
                        } else if (col == widestColumnPosition - 1) {
                            matrix[row][col] = c;
                            widestColumnPosition--;
                        } else {
                            matrix[row][col] = ' ';
                        }
                    }
                }
            }
            if (row < letterAColumnPosition) {
                c++;
            } else {
                c--;
            }
        }
        return matrix;
    }

    private void assertChosenLetterIsValid(String letter) {
        if (letter == null) {
            throw new IllegalArgumentException("Input must not be null");
        }
        String regex = "^[a-zA-Z]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(letter);
        boolean isValid = matcher.matches();
        if (!isValid) {
            throw new IllegalArgumentException("Input must be just one letter between a and z");
        }
    }
}
