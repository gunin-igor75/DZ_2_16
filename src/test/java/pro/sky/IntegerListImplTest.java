package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.exeption.InvalidateIndexException;
import pro.sky.exeption.NotFoundElementException;
import pro.sky.exeption.NullItemException;
import pro.sky.exeption.StorageFullException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.Value.*;

class IntegerListImplTest {
    private IntegerListImpl LIST;
    @BeforeEach
    void post() {
        LIST = new IntegerListImpl(5);
        LIST.add(1);
        LIST.add(2);
        LIST.add(5);
    }

    @Test
    void addTestOne() {
        assertAll(() -> assertThrows(StorageFullException.class,
                () -> LIST_FULL.add(ZERO)),
                () -> assertThrows(NullItemException.class,
                        () -> LIST.add(null)),
                () -> assertEquals(SIX, LIST.add(SIX)));
    }

    @Test
    void addTestTwo() {
        assertAll(() -> assertThrows(StorageFullException.class,
                        () -> LIST_FULL.add(ZERO,SIX)),
                () -> assertThrows(NullItemException.class,
                        () -> LIST.add(ONE, null)),
                () -> assertEquals(SIX, LIST.add(TWO, SIX)),
                () -> assertThrows(InvalidateIndexException.class,
                        () -> LIST.add(TEN,ONE)),
                () -> assertEquals(THREE, LIST.add(ZERO,THREE)));
    }

    @Test
    void setTest() {
        assertAll(() -> assertThrows(InvalidateIndexException.class,
                () -> LIST.set(TEN, ZERO)),
                () -> assertThrows(NullItemException.class,
                        () -> LIST.set(TWO, null)),
                () -> assertEquals(ZERO, LIST.set(TWO, ZERO)));
    }

    @Test
    void removeOne() {
        assertAll(() -> assertEquals(ONE, LIST.remove(ONE)),
                () -> assertThrows(NullItemException.class,
                        () ->LIST.remove(null)),
                () -> assertThrows(NotFoundElementException.class,
                        () ->LIST.remove(SIX))
        );
    }

    @Test
    void removeTwo() {
        assertAll(() -> assertEquals(FIVE, LIST.remove()),
                () -> assertThrows(InvalidateIndexException.class,
                        () -> LIST_EMPTY.remove()));
    }

    @Test
    void contains() {
        assertAll(() -> assertThrows(NullItemException.class,
                        () -> LIST_CONTAINS.contains(null)),
                () -> assertTrue(LIST_CONTAINS.contains(FIVE)),
                () -> assertFalse(LIST_CONTAINS.contains(SIX))
        );
    }

    @Test
    void indexOfTest() {
        assertAll(() -> assertThrows(NullItemException.class,
                        () -> LIST.indexOf(null)),
                () -> assertEquals(ONE, LIST.indexOf(TWO)),
                () -> assertEquals(MINUS_ONE, LIST.indexOf(SIX)));
    }
    @Test
    void lastIndexOfTest() {
        LIST.add(TWO);
        assertAll(() -> assertThrows(NullItemException.class,
                        () -> LIST.lastIndexOf(null)),
                () -> assertEquals(THREE, LIST.lastIndexOf(TWO)),
                () -> assertEquals(MINUS_ONE, LIST.lastIndexOf(SIX)));
    }
    @Test
    void getTest() {
        assertAll(() ->assertEquals(ONE, LIST.get(ZERO)),
                () -> assertThrows(InvalidateIndexException.class,
                        () -> LIST.get(SIX)));
    }

    @Test
    void equalsTest() {
        IntegerListImpl listNew = new IntegerListImpl(5);
        listNew.add(1);
        listNew.add(2);
        listNew.add(5);
        assertTrue(listNew.equals(LIST));
    }
    @Test
    void sizeTest() {
        assertAll(() -> assertEquals(THREE, LIST.size()),
                () -> assertNotEquals(ZERO, LIST.size()));
    }

    @Test
    void isEmptyTest() {
        assertAll(() -> assertTrue(LIST_EMPTY.isEmpty()),
                () -> assertFalse(LIST.isEmpty()));
    }

    @Test
    void clearTest() {
        LIST.clear();
        assertTrue(LIST.isEmpty());
    }

    @Test
    void toArrayTest() {
        assertThat(ARRAY).contains(LIST.toArray());
    }
    @Test
    void binarySearchTest() {
        assertAll(() -> assertTrue(LIST.binarySearch(FIVE)),
                () -> assertFalse(LIST.binarySearch(ZERO)));
    }
}