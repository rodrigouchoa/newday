package co.uk.newday;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiamondTest {
    //holds the size the matrix should be for each letter
    private static Map<Character, Integer> expectedMatrixSizeMap;

    private static final char[][] A_MATRIX = {{'A'}};
    private static final char[][] E_MATRIX = {
            {' '}, {' '}, {' '}, {' '}, {'A'}, {' '}, {' '}, {' '}, {' '},
            {' '}, {' '}, {' '}, {'B'}, {' '}, {'B'}, {' '}, {' '}, {' '},
            {' '}, {' '}, {'C'}, {' '}, {' '}, {' '}, {'C'}, {' '}, {' '},
            {' '}, {'D'}, {' '}, {' '}, {' '}, {' '}, {' '}, {'D'}, {' '},
            {'E'}, {' '}, {' '}, {' '}, {' '}, {' '}, {' '}, {' '}, {'E'},
            {' '}, {'D'}, {' '}, {' '}, {' '}, {' '}, {' '}, {'D'}, {' '},
            {' '}, {' '}, {'C'}, {' '}, {' '}, {' '}, {'C'}, {' '}, {' '},
            {' '}, {' '}, {' '}, {'B'}, {' '}, {'B'}, {' '}, {' '}, {' '},
            {' '}, {' '}, {' '}, {' '}, {'A'}, {' '}, {' '}, {' '}, {' '},
    };

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"aa", "1", "!", "~", "\n", "\t"})
    public void should_ThrowException_when_letterInvalid(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Diamond(input));
    }

    @Test
    public void matrixMapSizeShouldBeCorrect() {
        for (char c = 'A'; c <= 'Z'; c++) {
            int expected = expectedMatrixSizeMap.get(c);
            int actual = Diamond.MATRIX_MAP_SIZE.get(c);
            assertEquals(expected, actual);
        }
    }

    @Test
    public void shouldBuildMatrix_whenLetterIsA() {
        Diamond sut = new Diamond("A");
        char[][] actual = sut.getDiamondMatrix();
        assertArrayEquals(A_MATRIX, actual);
    }

    @Test
    public void shouldBuildMatrix_whenLetterIsE() {
        Diamond sut = new Diamond("E");
        char[][] actual = sut.getDiamondMatrix();
        assertArrayEquals(E_MATRIX, actual);
    }

    @BeforeAll
    public static void beforeAll() {
        expectedMatrixSizeMap = new HashMap<>();
        expectedMatrixSizeMap.put('A', 1);
        expectedMatrixSizeMap.put('B', 3);
        expectedMatrixSizeMap.put('C', 5);
        expectedMatrixSizeMap.put('D', 7);
        expectedMatrixSizeMap.put('E', 9);
        expectedMatrixSizeMap.put('F', 11);
        expectedMatrixSizeMap.put('G', 13);
        expectedMatrixSizeMap.put('H', 15);
        expectedMatrixSizeMap.put('I', 17);
        expectedMatrixSizeMap.put('J', 19);
        expectedMatrixSizeMap.put('K', 21);
        expectedMatrixSizeMap.put('L', 23);
        expectedMatrixSizeMap.put('M', 25);
        expectedMatrixSizeMap.put('N', 27);
        expectedMatrixSizeMap.put('O', 29);
        expectedMatrixSizeMap.put('P', 31);
        expectedMatrixSizeMap.put('Q', 33);
        expectedMatrixSizeMap.put('R', 35);
        expectedMatrixSizeMap.put('S', 37);
        expectedMatrixSizeMap.put('T', 39);
        expectedMatrixSizeMap.put('U', 41);
        expectedMatrixSizeMap.put('V', 43);
        expectedMatrixSizeMap.put('W', 45);
        expectedMatrixSizeMap.put('X', 47);
        expectedMatrixSizeMap.put('Y', 49);
        expectedMatrixSizeMap.put('Z', 51);
    }

}
