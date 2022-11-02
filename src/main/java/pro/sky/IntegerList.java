package pro.sky;

public interface IntegerList {
    int add(Integer item);

    int add(int index, Integer item);

    Integer set(int index, Integer item);

    int remove(Integer item);


    int remove();

    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    int get(int index);

    boolean equals(IntegerList otherList);

    int size();

    boolean isEmpty();

    void clear();

    Integer[] toArray();
}
