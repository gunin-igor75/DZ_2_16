package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.Value.ARRAY_SORT;
import static pro.sky.Value.RESULT;

class SortBubbleTest {
    private final SortBubble sortBubble = new SortBubble();

    @BeforeEach
    void init() {
        ARRAY_SORT = new Integer[]{3,10,1,9,5,7,6,8,4,2};
    }

    @Test
    void runTestOne() {
        sortBubble.run(ARRAY_SORT);
        assertArrayEquals(RESULT, ARRAY_SORT);
    }

    @Test
    void runTestTwo() {
        assertNotEquals(RESULT, ARRAY_SORT);
    }
}