package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.Value.ARRAY_SORT;
import static pro.sky.Value.RESULT;

class SortInsertionTest {
    private final SortInsertion sortInsertion = new SortInsertion();

    @BeforeEach
    void init() {
        ARRAY_SORT = new Integer[]{3, 10, 1, 9, 5, 7, 6, 8, 4, 2};
    }

    @Test
    void runTestOne() {
        sortInsertion.run(ARRAY_SORT);
        assertArrayEquals(RESULT, ARRAY_SORT);
    }

    @Test
    void runTestTwo() {
        assertNotEquals(RESULT, ARRAY_SORT);
    }
}