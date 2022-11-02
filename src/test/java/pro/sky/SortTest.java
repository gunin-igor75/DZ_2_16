package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.Value.*;

class SortTest {

    private final Sort sort = new Sort() {
        @Override
        public void run(Integer[] arr) {
        }
    };
    @BeforeEach
    void init() {
        ARRAY_SWAP = new Integer[]{THREE, TWO, ONE,FOUR, FIVE};
    }
    @Test
    void swapElementsTestOne() {
        sort.swapElements(ARRAY_SWAP, ZERO,TWO);
        assertArrayEquals(RESULT, ARRAY_SWAP);
    }

    @Test
    void swapElementsTestTwo() {
        assertNotEquals(RESULT, ARRAY_SWAP);
    }
}