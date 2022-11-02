package pro.sky;

public class Value {
    public static Integer ZERO = 0;
    public static Integer ONE = 1;
    public static Integer TWO = 2;
    public static Integer THREE = 3;
    public static Integer FOUR = 4;
    public static Integer FIVE = 5;
    public static Integer SIX = 6;
    public static Integer TEN = 10;

    public static Integer MINUS_ONE = -1;
    public static Integer[] ARRAY_SWAP = {3,2,1,4,5,6,7,8,9,10};
    public static Integer[] ARRAY_SORT = {3,10,1,9,5,7,6,8,4,2};
    public static Integer[] RESULT = {1,2,3,4,5,6,7,8,9,10};
    public static Integer[] ARRAY = {1,2,5};
    public static IntegerListImpl LIST_CONTAINS = new IntegerListImpl(9);

    static {
        LIST_CONTAINS.add(12);
        LIST_CONTAINS.add(9);
        LIST_CONTAINS.add(7);
        LIST_CONTAINS.add(1);
        LIST_CONTAINS.add(5);
        LIST_CONTAINS.add(4);
        LIST_CONTAINS.add(0);
        LIST_CONTAINS.add(25);
        LIST_CONTAINS.add(35);
    }

    public static IntegerListImpl LIST_FULL = new IntegerListImpl(3);

    static {
        LIST_FULL.add(1);
        LIST_FULL.add(2);
        LIST_FULL.add(3);
    }
    public static IntegerListImpl LIST_EMPTY = new IntegerListImpl(3);
}
